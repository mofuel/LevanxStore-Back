package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.*;
import com.levanxstore.domain.repository.CustomerRepository;
import com.levanxstore.domain.repository.SaleItemRepository;
import com.levanxstore.domain.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private static final Logger log = LoggerFactory.getLogger(SaleService.class);

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductStockService productStockService;

    public SaleService(SaleRepository saleRepository,
                       SaleItemRepository saleItemRepository,
                       CustomerRepository customerRepository,
                       ProductStockService productStockService) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.customerRepository = customerRepository;
        this.productStockService = productStockService;
    }

    @Transactional
    public SaleResponseDTO createSale(CreateSaleRequestDTO request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("La venta debe tener al menos un item");
        }
        if (request.getPaymentMethod() == null) {
            throw new IllegalArgumentException("El método de pago es obligatorio");
        }

        // 1. Crear Sale (sin receiptNumber aún)
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setDate(LocalDateTime.now());
        saleDTO.setPaymentMethod(request.getPaymentMethod());
        saleDTO.setStatus("PAID");

        // 2. Cliente
        if (request.getCustomerId() != null) {
            CustomerDTO customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
            saleDTO.setCustomerId(customer.getId());
            saleDTO.setCustomerFirstName(customer.getFirstName());
            saleDTO.setCustomerLastName(customer.getLastName());
            saleDTO.setCustomerPhone(customer.getPhone());
        } else {
            saleDTO.setCustomerFirstName(request.getCustomerFirstName());
            saleDTO.setCustomerLastName(request.getCustomerLastName());
            saleDTO.setCustomerPhone(request.getCustomerPhone());
        }

        // 3. Guardar para obtener ID, luego generar receiptNumber (thread-safe)
        saleDTO.setTotalAmount(BigDecimal.ZERO);
        SaleDTO savedSale = saleRepository.save(saleDTO);
        savedSale.setReceiptNumber("LVX-" + String.format("%05d", savedSale.getId()));
        savedSale = saleRepository.save(savedSale);

        // 4. Procesar items
        BigDecimal total = BigDecimal.ZERO;
        List<SaleItemDTO> items = new ArrayList<>();
        List<String> lowStockAlerts = new ArrayList<>();

        for (CreateSaleItemDTO itemReq : request.getItems()) {
            if (itemReq.getProductStockId() == null) {
                throw new IllegalArgumentException("El ID del producto es obligatorio en cada item");
            }
            if (itemReq.getQuantity() == null || itemReq.getQuantity() <= 0) {
                throw new IllegalArgumentException("La cantidad de cada item debe ser mayor a 0");
            }

            ProductStockDTO stock = productStockService.findById(itemReq.getProductStockId())
                    .orElseThrow(() -> new IllegalArgumentException("Stock no encontrado ID: " + itemReq.getProductStockId()));

            if (stock.getQuantity() == null || stock.getQuantity() < itemReq.getQuantity()) {
                throw new IllegalArgumentException("Stock insuficiente para: " + stock.getProductName());
            }

            // Deducir stock
            ProductStockDTO updatedStock = productStockService.adjustStock(itemReq.getProductStockId(), -itemReq.getQuantity());

            // Verificar stock bajo
            if (updatedStock.getMinStock() != null && updatedStock.getQuantity() < updatedStock.getMinStock()) {
                String alert = "Stock bajo: " + updatedStock.getProductName()
                        + " (" + updatedStock.getQuantity() + " unidades, mínimo: " + updatedStock.getMinStock() + ")";
                lowStockAlerts.add(alert);
                log.warn(alert);
            }

            // Calcular item
            if (stock.getSalePrice() == null) {
                throw new IllegalArgumentException("Precio de venta no configurado para: " + stock.getProductName());
            }
            BigDecimal unitPrice = stock.getSalePrice();
            BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(itemReq.getQuantity()))
                    .setScale(2, RoundingMode.HALF_UP);
            BigDecimal discount = itemReq.getDiscountAmount() != null ? itemReq.getDiscountAmount() : BigDecimal.ZERO;
            BigDecimal finalSubtotal = subtotal.subtract(discount);

            SaleItemDTO itemDTO = new SaleItemDTO();
            itemDTO.setSaleId(savedSale.getId());
            itemDTO.setProductStockId(itemReq.getProductStockId());
            itemDTO.setProductName(stock.getProductName());
            itemDTO.setQuantity(itemReq.getQuantity());
            itemDTO.setUnitPrice(unitPrice);
            itemDTO.setDiscountAmount(discount);
            itemDTO.setSubtotal(finalSubtotal);

            items.add(saleItemRepository.save(itemDTO));
            total = total.add(finalSubtotal);
        }

        // 5. Actualizar total de la venta
        savedSale.setTotalAmount(total);
        SaleDTO finalSale = saleRepository.save(savedSale);

        log.info("Venta creada: {} - Total: {}", finalSale.getReceiptNumber(), finalSale.getTotalAmount());

        return new SaleResponseDTO(finalSale, lowStockAlerts);
    }

    @Transactional
    public SaleDTO cancelSale(Long id) {
        SaleDTO sale = saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        if (!"PAID".equals(sale.getStatus())) {
            throw new IllegalArgumentException("La venta ya fue cancelada");
        }

        // Restaurar stock de cada item
        List<SaleItemDTO> items = saleItemRepository.findBySaleId(id);
        for (SaleItemDTO item : items) {
            productStockService.adjustStock(item.getProductStockId(), item.getQuantity());
        }

        sale.setStatus("CANCELED");
        SaleDTO cancelled = saleRepository.save(sale);
        log.info("Venta cancelada: {}", cancelled.getReceiptNumber());
        return cancelled;
    }

    @Transactional
    public SaleItemDTO returnItem(Long saleId, Long itemId) {
        SaleDTO sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        if (!"PAID".equals(sale.getStatus())) {
            throw new IllegalArgumentException("No se puede devolver items de una venta cancelada");
        }

        SaleItemDTO item = saleItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item no encontrado"));

        if (!item.getSaleId().equals(saleId)) {
            throw new IllegalArgumentException("El item no pertenece a esta venta");
        }

        if (item.getQuantity() == 0) {
            throw new IllegalArgumentException("Este item ya fue devuelto");
        }

        // Restaurar stock
        productStockService.adjustStock(item.getProductStockId(), item.getQuantity());

        // Marcar item como devuelto (quantity = 0)
        item.setQuantity(0);
        item.setSubtotal(BigDecimal.ZERO);
        item.setDiscountAmount(BigDecimal.ZERO);
        saleItemRepository.save(item);

        // Recalcular total de la venta
        List<SaleItemDTO> allItems = saleItemRepository.findBySaleId(saleId);
        BigDecimal newTotal = allItems.stream()
                .map(SaleItemDTO::getSubtotal)
                .filter(java.util.Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotalAmount(newTotal);
        saleRepository.save(sale);

        log.info("Item devuelto - Venta: {}, Item: {}", saleId, itemId);
        return item;
    }

    @Transactional
    public SaleDTO save(SaleDTO dto) {
        if (dto.getPaymentMethod() == null) {
            throw new IllegalArgumentException("El método de pago es obligatorio");
        }
        if (dto.getDate() == null) {
            dto.setDate(LocalDateTime.now());
        }
        if (dto.getStatus() == null) {
            dto.setStatus("PAID");
        }
        if (dto.getTotalAmount() == null || dto.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto total es obligatorio y debe ser mayor o igual a 0");
        }
        if (dto.getCustomerId() != null) {
            customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        }
        SaleDTO saved = saleRepository.save(dto);
        if (saved.getReceiptNumber() == null) {
            saved.setReceiptNumber("LVX-" + String.format("%05d", saved.getId()));
            saved = saleRepository.save(saved);
        }
        return saved;
    }

    public Optional<SaleDTO> findById(Long id) {
        return saleRepository.findById(id);
    }

    public List<SaleDTO> findAll() {
        return saleRepository.findAll();
    }

    public List<SaleDTO> findByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
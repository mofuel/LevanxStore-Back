package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.domain.repository.ProductStockRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.transaction.Transactional;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductStockService {

    private static final Logger log = LoggerFactory.getLogger(ProductStockService.class);

    private final ProductStockRepository productStockRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ProductStockService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public ProductStockDTO save(ProductStockDTO dto) {
        if (dto.getProductId() == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (dto.getModelId() == null) {
            throw new IllegalArgumentException("El modelo es obligatorio");
        }
        if (dto.getQuantity() == null || dto.getQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor o igual a 0");
        }
        if (dto.getCostPrice() == null || dto.getCostPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio de costo debe ser mayor o igual a 0");
        }
        if (dto.getSalePrice() == null || dto.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio de venta debe ser mayor o igual a 0");
        }
        return productStockRepository.save(dto);
    }

    @Transactional
    public ProductStockDTO adjustStock(Long id, int delta) {
        int retries = 3;
        while (true) {
            try {
                ProductStockDTO updated = productStockRepository.adjustStock(id, delta);
                if (updated.getMinStock() != null && updated.getQuantity() < updated.getMinStock()) {
                    log.warn("Stock bajo - Producto: {}, Stock actual: {}, Mínimo: {}",
                            updated.getProductName(), updated.getQuantity(), updated.getMinStock());
                }
                return updated;
            } catch (ObjectOptimisticLockingFailureException e) {
                entityManager.clear();
                retries--;
                if (retries <= 0) {
                    throw e;
                }
                log.warn("Conflicto de concurrencia al ajustar stock (id={}), reintentando...", id);
            }
        }
    }

    public Optional<ProductStockDTO> findById(Long id) {
        return productStockRepository.findById(id);
    }

    public List<ProductStockDTO> findAll() {
        return productStockRepository.findAll();
    }

    public List<ProductStockDTO> findByProductId(Long productId) {
        return productStockRepository.findByProductId(productId);
    }

    public void deleteById(Long id) {
        productStockRepository.deleteById(id);
    }
}
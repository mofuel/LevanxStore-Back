package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.domain.repository.ProductStockRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductStockService {

    private final ProductStockRepository productStockRepository;

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
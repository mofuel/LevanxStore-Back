package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.ProductDTO;
import com.levanxstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO save(ProductDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (dto.getActive() == null) {
            dto.setActive(true);
        }
        dto.setName(dto.getName().trim());
        return productRepository.save(dto);
    }

    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll();
    }

    public List<ProductDTO> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.ProductModelDTO;
import com.levanxstore.domain.repository.ProductModelRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductModelService {

    private final ProductModelRepository productModelRepository;

    public ProductModelService(ProductModelRepository productModelRepository) {
        this.productModelRepository = productModelRepository;
    }

    public ProductModelDTO save(ProductModelDTO dto) {
        if (dto.getBrand() == null || dto.getBrand().isBlank()) {
            throw new IllegalArgumentException("La marca es obligatoria");
        }
        if (dto.getModel() == null || dto.getModel().isBlank()) {
            throw new IllegalArgumentException("El modelo es obligatorio");
        }
        dto.setBrand(dto.getBrand().trim());
        dto.setModel(dto.getModel().trim());
        if (productModelRepository.findByBrandAndModel(dto.getBrand(), dto.getModel()).isPresent()) {
            throw new IllegalArgumentException("Ya existe esa combinación de marca y modelo");
        }
        return productModelRepository.save(dto);
    }

    public Optional<ProductModelDTO> findById(Long id) {
        return productModelRepository.findById(id);
    }

    public List<ProductModelDTO> findAll() {
        return productModelRepository.findAll();
    }

    public List<ProductModelDTO> findByBrand(String brand) {
        return productModelRepository.findByBrand(brand);
    }

    public void deleteById(Long id) {
        productModelRepository.deleteById(id);
    }
}

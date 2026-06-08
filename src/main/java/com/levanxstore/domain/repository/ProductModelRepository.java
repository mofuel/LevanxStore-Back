package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.ProductModelDTO;
import java.util.List;
import java.util.Optional;

public interface ProductModelRepository {

    ProductModelDTO save(ProductModelDTO productModelDTO);

    Optional<ProductModelDTO> findById(Long id);

    List<ProductModelDTO> findAll();

    List<ProductModelDTO> findByBrand(String brand);

    Optional<ProductModelDTO> findByBrandAndModel(String brand, String model);

    void deleteById(Long id);
}

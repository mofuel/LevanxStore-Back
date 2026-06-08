package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.ProductDTO;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    ProductDTO save(ProductDTO productDTO);

    Optional<ProductDTO> findById(Long id);

    List<ProductDTO> findAll();

    List<ProductDTO> findByCategoryId(Long categoryId);

    Optional<ProductDTO> findByName(String name);

    void deleteById(Long id);

}

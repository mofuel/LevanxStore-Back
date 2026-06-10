package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.ProductStockDTO;
import java.util.List;
import java.util.Optional;

public interface ProductStockRepository {

    ProductStockDTO save(ProductStockDTO productStockDTO);

    Optional<ProductStockDTO> findById(Long id);

    List<ProductStockDTO> findAll();

    List<ProductStockDTO> findByProductId(Long productId);

    List<ProductStockDTO> findByModelId(Long modelId);

    Optional<ProductStockDTO> findByProductIdAndModelId(Long productId, Long modelId);

    void deleteById(Long id);

    ProductStockDTO adjustStock(Long id, int delta);

}

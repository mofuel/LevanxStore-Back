package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductStockCrudRepository extends JpaRepository<ProductStock, Long> {

    List<ProductStock> findByProductId(Long productId);

    List<ProductStock> findByModelId(Long modelId);

    Optional<ProductStock> findByProductIdAndModelId(Long productId, Long modelId);

}

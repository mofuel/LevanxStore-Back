package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductModelCrudRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByBrand(String brand);

    Optional<ProductModel> findByBrandAndModel(String brand, String model);
}

package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleItemCrudRepository extends JpaRepository<SaleItem, Long> {

    List<SaleItem> findBySaleId(Long saleId);
    
}

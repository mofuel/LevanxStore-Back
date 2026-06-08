package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleCrudRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByCustomerId(Long customerId);

    List<Sale> findByStatus(Sale.SaleStatus status);
    
}

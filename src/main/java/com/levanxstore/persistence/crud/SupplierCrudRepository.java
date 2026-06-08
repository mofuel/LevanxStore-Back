package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SupplierCrudRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByName(String name);
}

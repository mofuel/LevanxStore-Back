package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPhone(String phone);

}

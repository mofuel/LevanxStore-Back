package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.LoyaltyAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoyaltyAccountCrudRepository extends JpaRepository<LoyaltyAccount, Long> {

    Optional<LoyaltyAccount> findByCustomerId(Long customerId);

    Optional<LoyaltyAccount> findByToken(String token);
}

package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InvestorCrudRepository extends JpaRepository<Investor, Long> {

    Optional<Investor> findByPhone(String phone);

    Optional<Investor> findByEmail(String email);

}

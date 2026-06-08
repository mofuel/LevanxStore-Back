package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import java.util.List;
import java.util.Optional;

public interface LoyaltyAccountRepository {

    LoyaltyAccountDTO save(LoyaltyAccountDTO loyaltyAccountDTO);

    Optional<LoyaltyAccountDTO> findById(Long id);

    List<LoyaltyAccountDTO> findAll();

    Optional<LoyaltyAccountDTO> findByCustomerId(Long customerId);

    Optional<LoyaltyAccountDTO> findByToken(String token);
    
    void deleteById(Long id);

}
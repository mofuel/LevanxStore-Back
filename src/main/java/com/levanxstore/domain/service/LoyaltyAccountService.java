package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import com.levanxstore.domain.repository.LoyaltyAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoyaltyAccountService {

    private final LoyaltyAccountRepository loyaltyAccountRepository;

    public LoyaltyAccountService(LoyaltyAccountRepository loyaltyAccountRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
    }

    public LoyaltyAccountDTO save(LoyaltyAccountDTO dto) {
        if (dto.getCustomerId() == null) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (dto.getPoints() == null || dto.getPoints() < 0) {
            dto.setPoints(0);
        }
        return loyaltyAccountRepository.save(dto);
    }

    public Optional<LoyaltyAccountDTO> findById(Long id) {
        return loyaltyAccountRepository.findById(id);
    }

    public List<LoyaltyAccountDTO> findAll() {
        return loyaltyAccountRepository.findAll();
    }

    public Optional<LoyaltyAccountDTO> findByCustomerId(Long customerId) {
        return loyaltyAccountRepository.findByCustomerId(customerId);
    }

    public void deleteById(Long id) {
        loyaltyAccountRepository.deleteById(id);
    }
}

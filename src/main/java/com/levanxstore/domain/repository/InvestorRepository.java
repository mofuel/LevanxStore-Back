package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.InvestorDTO;
import java.util.List;
import java.util.Optional;

public interface InvestorRepository {

    InvestorDTO save(InvestorDTO investorDTO);

    Optional<InvestorDTO> findById(Long id);

    List<InvestorDTO> findAll();

    Optional<InvestorDTO> findByPhone(String phone);

    Optional<InvestorDTO> findByEmail(String email);

    void deleteById(Long id);
    
}

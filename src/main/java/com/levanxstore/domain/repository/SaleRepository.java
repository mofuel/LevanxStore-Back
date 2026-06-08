package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.SaleDTO;
import java.util.List;
import java.util.Optional;

public interface SaleRepository {

    SaleDTO save(SaleDTO saleDTO);

    Optional<SaleDTO> findById(Long id);

    List<SaleDTO> findAll();

    List<SaleDTO> findByCustomerId(Long customerId);

    List<SaleDTO> findByStatus(String status);

    void deleteById(Long id);
    
}

package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.SaleItemDTO;
import java.util.List;
import java.util.Optional;

public interface SaleItemRepository {

    SaleItemDTO save(SaleItemDTO saleItemDTO);

    Optional<SaleItemDTO> findById(Long id);

    List<SaleItemDTO> findAll();

    List<SaleItemDTO> findBySaleId(Long saleId);

    void deleteById(Long id);
    
}
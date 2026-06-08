package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.SaleItemDTO;
import com.levanxstore.domain.repository.SaleItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;

    public SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public SaleItemDTO save(SaleItemDTO dto) {
        if (dto.getQuantity() == null || dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        return saleItemRepository.save(dto);
    }

    public Optional<SaleItemDTO> findById(Long id) {
        return saleItemRepository.findById(id);
    }

    public List<SaleItemDTO> findAll() {
        return saleItemRepository.findAll();
    }

    public List<SaleItemDTO> findBySaleId(Long saleId) {
        return saleItemRepository.findBySaleId(saleId);
    }

    public void deleteById(Long id) {
        saleItemRepository.deleteById(id);
    }
}
package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.SaleDTO;
import com.levanxstore.domain.repository.SaleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public SaleDTO save(SaleDTO dto) {
        if (dto.getPaymentMethod() == null) {
            throw new IllegalArgumentException("El método de pago es obligatorio");
        }
        if (dto.getDate() == null) {
            dto.setDate(LocalDateTime.now());
        }
        if (dto.getStatus() == null) {
            dto.setStatus("PAID");
        }
        return saleRepository.save(dto);
    }

    public Optional<SaleDTO> findById(Long id) {
        return saleRepository.findById(id);
    }

    public List<SaleDTO> findAll() {
        return saleRepository.findAll();
    }

    public List<SaleDTO> findByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}

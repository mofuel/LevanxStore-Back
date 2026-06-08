package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import com.levanxstore.domain.repository.MarketingPartnerRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MarketingPartnerService {

    private final MarketingPartnerRepository marketingPartnerRepository;

    public MarketingPartnerService(MarketingPartnerRepository marketingPartnerRepository) {
        this.marketingPartnerRepository = marketingPartnerRepository;
    }

    public MarketingPartnerDTO save(MarketingPartnerDTO dto) {
        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if (dto.getCreditsAmount() == null) {
            dto.setCreditsAmount(BigDecimal.ZERO);
        }
        dto.setFirstName(dto.getFirstName().trim());
        dto.setLastName(dto.getLastName().trim());
        return marketingPartnerRepository.save(dto);
    }

    public Optional<MarketingPartnerDTO> findById(Long id) {
        return marketingPartnerRepository.findById(id);
    }

    public List<MarketingPartnerDTO> findAll() {
        return marketingPartnerRepository.findAll();
    }

    public void deleteById(Long id) {
        marketingPartnerRepository.deleteById(id);
    }
}

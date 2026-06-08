package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import java.util.List;
import java.util.Optional;

public interface MarketingPartnerRepository {

    MarketingPartnerDTO save(MarketingPartnerDTO marketingPartnerDTO);

    Optional<MarketingPartnerDTO> findById(Long id);

    List<MarketingPartnerDTO> findAll();

    void deleteById(Long id);
    
}

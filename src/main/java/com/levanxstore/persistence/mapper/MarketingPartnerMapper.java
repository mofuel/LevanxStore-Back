package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import com.levanxstore.persistence.entity.MarketingPartner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarketingPartnerMapper {

    MarketingPartnerDTO toDto(MarketingPartner marketingPartner);

    MarketingPartner toEntity(MarketingPartnerDTO marketingPartnerDTO);
}

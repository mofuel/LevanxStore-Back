package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import com.levanxstore.persistence.entity.MarketingPartner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MarketingPartnerMapper {

    MarketingPartnerDTO toDto(MarketingPartner marketingPartner);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    MarketingPartner toEntity(MarketingPartnerDTO marketingPartnerDTO);
}

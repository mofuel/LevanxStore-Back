package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.InvestorDTO;
import com.levanxstore.persistence.entity.Investor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvestorMapper {

    InvestorDTO toDto(Investor investor);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Investor toEntity(InvestorDTO investorDTO);
}

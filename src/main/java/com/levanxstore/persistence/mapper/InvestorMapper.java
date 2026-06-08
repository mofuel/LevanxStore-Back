package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.InvestorDTO;
import com.levanxstore.persistence.entity.Investor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvestorMapper {

    InvestorDTO toDto(Investor investor);

    Investor toEntity(InvestorDTO investorDTO);
}

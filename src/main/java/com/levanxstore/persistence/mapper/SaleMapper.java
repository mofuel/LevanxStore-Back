package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.SaleDTO;
import com.levanxstore.persistence.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "customerId", source = "customer.id")
    SaleDTO toDto(Sale sale);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Sale toEntity(SaleDTO saleDTO);
}

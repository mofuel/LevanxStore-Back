package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.SaleItemDTO;
import com.levanxstore.persistence.entity.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleItemMapper {

    @Mapping(target = "saleId", source = "sale.id")
    @Mapping(target = "productStockId", source = "productStock.id")
    @Mapping(target = "productName", source = "productStock.product.name")
    SaleItemDTO toDto(SaleItem saleItem);

    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "productStock", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SaleItem toEntity(SaleItemDTO saleItemDTO);
}

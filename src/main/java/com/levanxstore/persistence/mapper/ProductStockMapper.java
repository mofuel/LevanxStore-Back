package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.persistence.entity.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "modelId", source = "model.id")
    @Mapping(target = "modelBrand", source = "model.brand")
    @Mapping(target = "modelName", source = "model.model")
    ProductStockDTO toDto(ProductStock productStock);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "model", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductStock toEntity(ProductStockDTO productStockDTO);
}

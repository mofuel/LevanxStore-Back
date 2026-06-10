package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.ProductModelDTO;
import com.levanxstore.persistence.entity.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    ProductModelDTO toDto(ProductModel productModel);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductModel toEntity(ProductModelDTO productModelDTO);
}

package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.ProductModelDTO;
import com.levanxstore.persistence.entity.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    ProductModelDTO toDto(ProductModel productModel);

    ProductModel toEntity(ProductModelDTO productModelDTO);
}

package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.SupplierDTO;
import com.levanxstore.persistence.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDTO toDto(Supplier supplier);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Supplier toEntity(SupplierDTO supplierDTO);
}

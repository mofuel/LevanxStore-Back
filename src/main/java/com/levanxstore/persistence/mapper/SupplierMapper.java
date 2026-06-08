package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.SupplierDTO;
import com.levanxstore.persistence.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDTO toDto(Supplier supplier);

    Supplier toEntity(SupplierDTO supplierDTO);
}

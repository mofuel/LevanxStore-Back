package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.ExpenseDTO;
import com.levanxstore.persistence.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(target = "supplierId", source = "supplier.id")
    @Mapping(target = "supplierName", source = "supplier.name")
    ExpenseDTO toDto(Expense expense);

    @Mapping(target = "supplier", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Expense toEntity(ExpenseDTO expenseDTO);
}

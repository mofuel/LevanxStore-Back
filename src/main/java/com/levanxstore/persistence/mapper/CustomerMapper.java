package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.CustomerDTO;
import com.levanxstore.persistence.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(Customer customer);

    @Mapping(target = "loyaltyAccount", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Customer toEntity(CustomerDTO customerDTO);
}

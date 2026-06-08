package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import com.levanxstore.persistence.entity.LoyaltyAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoyaltyAccountMapper {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerName", expression = "java(loyaltyAccount.getCustomer().getFirstName() + \" \" + loyaltyAccount.getCustomer().getLastName())")
    LoyaltyAccountDTO toDto(LoyaltyAccount loyaltyAccount);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoyaltyAccount toEntity(LoyaltyAccountDTO loyaltyAccountDTO);
}

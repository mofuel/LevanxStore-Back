package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import com.levanxstore.persistence.entity.LoyaltyAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoyaltyAccountMapper {

    @Mapping(target = "customerId", expression = "java(loyaltyAccount.getCustomer() != null ? loyaltyAccount.getCustomer().getId() : null)")
    @Mapping(target = "customerName", expression = "java(loyaltyAccount.getCustomer() != null ? loyaltyAccount.getCustomer().getFirstName() + \" \" + loyaltyAccount.getCustomer().getLastName() : null)")
    LoyaltyAccountDTO toDto(LoyaltyAccount loyaltyAccount);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoyaltyAccount toEntity(LoyaltyAccountDTO loyaltyAccountDTO);
}

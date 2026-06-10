package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.CategoryDTO;
import com.levanxstore.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);
}

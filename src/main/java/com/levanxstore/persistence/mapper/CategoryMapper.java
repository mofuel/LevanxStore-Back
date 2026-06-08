package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.CategoryDTO;
import com.levanxstore.persistence.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    Category toEntity(CategoryDTO categoryDTO);
}

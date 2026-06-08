package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.CategoryDTO;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    CategoryDTO save(CategoryDTO categoryDTO);

    Optional<CategoryDTO> findById(Long id);

    Optional<CategoryDTO> findByName(String name);

    List<CategoryDTO> findAll();

    boolean existsByName(String name);

    void deleteById(Long id);

}

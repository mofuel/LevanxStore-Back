package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.CategoryDTO;
import com.levanxstore.domain.repository.CategoryRepository;
import com.levanxstore.persistence.crud.CategoryCrudRepository;
import com.levanxstore.persistence.entity.Category;
import com.levanxstore.persistence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryCrudRepository crudRepository;
    private final CategoryMapper mapper;

    public CategoryRepositoryImpl(CategoryCrudRepository crudRepository, CategoryMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category entity = mapper.toEntity(categoryDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<CategoryDTO> findByName(String name) {
        return crudRepository.findByName(name).map(mapper::toDto);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        return crudRepository.existsByName(name);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

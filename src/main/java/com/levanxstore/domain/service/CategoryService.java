package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.CategoryDTO;
import com.levanxstore.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO save(CategoryDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría es obligatorio");
        }
        if (categoryRepository.existsByName(dto.getName().trim())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");
        }
        dto.setName(dto.getName().trim());
        return categoryRepository.save(dto);
    }

    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}

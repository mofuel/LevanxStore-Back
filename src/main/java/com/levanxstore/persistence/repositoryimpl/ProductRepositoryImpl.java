package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.ProductDTO;
import com.levanxstore.domain.repository.ProductRepository;
import com.levanxstore.persistence.crud.ProductCrudRepository;
import com.levanxstore.persistence.entity.Product;
import com.levanxstore.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(ProductCrudRepository crudRepository, ProductMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product entity = mapper.toEntity(productDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ProductDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCategoryId(Long categoryId) {
        return crudRepository.findByCategoryId(categoryId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findByName(String name) {
        return crudRepository.findByName(name).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

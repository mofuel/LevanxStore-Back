package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.ProductModelDTO;
import com.levanxstore.domain.repository.ProductModelRepository;
import com.levanxstore.persistence.crud.ProductModelCrudRepository;
import com.levanxstore.persistence.entity.ProductModel;
import com.levanxstore.persistence.mapper.ProductModelMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductModelRepositoryImpl implements ProductModelRepository {

    private final ProductModelCrudRepository crudRepository;
    private final ProductModelMapper mapper;

    public ProductModelRepositoryImpl(ProductModelCrudRepository crudRepository, ProductModelMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductModelDTO save(ProductModelDTO productModelDTO) {
        ProductModel entity = mapper.toEntity(productModelDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<ProductModelDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ProductModelDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductModelDTO> findByBrand(String brand) {
        return crudRepository.findByBrand(brand).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductModelDTO> findByBrandAndModel(String brand, String model) {
        return crudRepository.findByBrandAndModel(brand, model).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

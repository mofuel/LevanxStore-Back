package com.levanxstore.persistence.repositoryimpl;


import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.domain.repository.ProductStockRepository;
import com.levanxstore.persistence.crud.ProductStockCrudRepository;
import com.levanxstore.persistence.entity.ProductStock;
import com.levanxstore.persistence.mapper.ProductStockMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductStockRepositoryImpl implements ProductStockRepository {

    private final ProductStockCrudRepository crudRepository;
    private final ProductStockMapper mapper;

    public ProductStockRepositoryImpl(ProductStockCrudRepository crudRepository, ProductStockMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductStockDTO save(ProductStockDTO productStockDTO) {
        ProductStock entity = mapper.toEntity(productStockDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<ProductStockDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ProductStockDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductStockDTO> findByProductId(Long productId) {
        return crudRepository.findByProductId(productId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductStockDTO> findByModelId(Long modelId) {
        return crudRepository.findByModelId(modelId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductStockDTO> findByProductIdAndModelId(Long productId, Long modelId) {
        return crudRepository.findByProductIdAndModelId(productId, modelId).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

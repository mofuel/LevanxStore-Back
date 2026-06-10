package com.levanxstore.persistence.repositoryimpl;


import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.domain.repository.ProductStockRepository;
import com.levanxstore.persistence.crud.ProductStockCrudRepository;
import com.levanxstore.persistence.entity.Product;
import com.levanxstore.persistence.entity.ProductModel;
import com.levanxstore.persistence.entity.ProductStock;
import com.levanxstore.persistence.mapper.ProductStockMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductStockRepositoryImpl implements ProductStockRepository {

    private final ProductStockCrudRepository crudRepository;
    private final ProductStockMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public ProductStockRepositoryImpl(ProductStockCrudRepository crudRepository, ProductStockMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ProductStockDTO save(ProductStockDTO productStockDTO) {
        ProductStock entity = mapper.toEntity(productStockDTO);
        if (productStockDTO.getProductId() != null) {
            entity.setProduct(entityManager.getReference(Product.class, productStockDTO.getProductId()));
        }
        if (productStockDTO.getModelId() != null) {
            entity.setModel(entityManager.getReference(ProductModel.class, productStockDTO.getModelId()));
        }
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

    @Override
    public ProductStockDTO adjustStock(Long id, int delta) {
        ProductStock entity = crudRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stock no encontrado con id: " + id));
        int newQuantity = entity.getQuantity() + delta;
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + entity.getProduct().getName());
        }
        entity.setQuantity(newQuantity);
        return mapper.toDto(crudRepository.save(entity));
    }
}

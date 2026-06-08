package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.SaleItemDTO;
import com.levanxstore.domain.repository.SaleItemRepository;
import com.levanxstore.persistence.crud.SaleItemCrudRepository;
import com.levanxstore.persistence.entity.SaleItem;
import com.levanxstore.persistence.mapper.SaleItemMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SaleItemRepositoryImpl implements SaleItemRepository {

    private final SaleItemCrudRepository crudRepository;
    private final SaleItemMapper mapper;

    public SaleItemRepositoryImpl(SaleItemCrudRepository crudRepository, SaleItemMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleItemDTO save(SaleItemDTO saleItemDTO) {
        SaleItem entity = mapper.toEntity(saleItemDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<SaleItemDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<SaleItemDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleItemDTO> findBySaleId(Long saleId) {
        return crudRepository.findBySaleId(saleId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.SupplierDTO;
import com.levanxstore.domain.repository.SupplierRepository;
import com.levanxstore.persistence.crud.SupplierCrudRepository;
import com.levanxstore.persistence.entity.Supplier;
import com.levanxstore.persistence.mapper.SupplierMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SupplierRepositoryImpl implements SupplierRepository {

    private final SupplierCrudRepository crudRepository;
    private final SupplierMapper mapper;

    public SupplierRepositoryImpl(SupplierCrudRepository crudRepository, SupplierMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        Supplier entity = mapper.toEntity(supplierDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<SupplierDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<SupplierDTO> findByName(String name) {
        return crudRepository.findByName(name).map(mapper::toDto);
    }

    @Override
    public List<SupplierDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

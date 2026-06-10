package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.SaleDTO;
import com.levanxstore.domain.repository.SaleRepository;
import com.levanxstore.persistence.crud.SaleCrudRepository;
import com.levanxstore.persistence.entity.Customer;
import com.levanxstore.persistence.entity.Sale;
import com.levanxstore.persistence.mapper.SaleMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final SaleCrudRepository crudRepository;
    private final SaleMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public SaleRepositoryImpl(SaleCrudRepository crudRepository, SaleMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public SaleDTO save(SaleDTO saleDTO) {
        Sale entity = mapper.toEntity(saleDTO);
        if (saleDTO.getCustomerId() != null) {
            entity.setCustomer(entityManager.getReference(Customer.class, saleDTO.getCustomerId()));
        }
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<SaleDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<SaleDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> findByCustomerId(Long customerId) {
        return crudRepository.findByCustomerId(customerId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> findByStatus(String status) {
        return crudRepository.findByStatus(Sale.SaleStatus.valueOf(status)).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

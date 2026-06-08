package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.CustomerDTO;
import com.levanxstore.domain.repository.CustomerRepository;
import com.levanxstore.persistence.crud.CustomerCrudRepository;
import com.levanxstore.persistence.entity.Customer;
import com.levanxstore.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerCrudRepository crudRepository;
    private final CustomerMapper mapper;

    public CustomerRepositoryImpl(CustomerCrudRepository crudRepository, CustomerMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer entity = mapper.toEntity(customerDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<CustomerDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> findByPhone(String phone) {
        return crudRepository.findByPhone(phone).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

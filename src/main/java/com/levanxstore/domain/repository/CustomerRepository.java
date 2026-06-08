package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.CustomerDTO;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    CustomerDTO save(CustomerDTO customerDTO);

    Optional<CustomerDTO> findById(Long id);

    List<CustomerDTO> findAll();

    Optional<CustomerDTO> findByPhone(String phone);

    void deleteById(Long id);

}

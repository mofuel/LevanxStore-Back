package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.CustomerDTO;
import com.levanxstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO save(CustomerDTO dto) {
        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if (dto.getPhone() == null || dto.getPhone().isBlank()) {
            throw new IllegalArgumentException("El teléfono es obligatorio");
        }
        dto.setFirstName(dto.getFirstName().trim());
        dto.setLastName(dto.getLastName().trim());
        dto.setPhone(dto.getPhone().trim());
        if (customerRepository.findByPhone(dto.getPhone()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con ese teléfono");
        }
        return customerRepository.save(dto);
    }

    public Optional<CustomerDTO> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll();
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

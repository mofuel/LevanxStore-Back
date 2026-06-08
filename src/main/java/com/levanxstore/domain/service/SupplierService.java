package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.SupplierDTO;
import com.levanxstore.domain.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierDTO save(SupplierDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del proveedor es obligatorio");
        }
        dto.setName(dto.getName().trim());
        if (supplierRepository.findByName(dto.getName()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un proveedor con ese nombre");
        }
        return supplierRepository.save(dto);
    }

    public Optional<SupplierDTO> findById(Long id) {
        return supplierRepository.findById(id);
    }

    public List<SupplierDTO> findAll() {
        return supplierRepository.findAll();
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }
}

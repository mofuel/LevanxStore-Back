package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.SupplierDTO;
import java.util.List;
import java.util.Optional;

public interface SupplierRepository {

    SupplierDTO save(SupplierDTO supplierDTO);

    Optional<SupplierDTO> findById(Long id);

    Optional<SupplierDTO> findByName(String name);

    List<SupplierDTO> findAll();

    void deleteById(Long id);

}
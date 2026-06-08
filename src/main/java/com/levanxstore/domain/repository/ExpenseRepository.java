package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.ExpenseDTO;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    ExpenseDTO save(ExpenseDTO expenseDTO);

    Optional<ExpenseDTO> findById(Long id);

    List<ExpenseDTO> findAll();

    List<ExpenseDTO> findBySupplierId(Long supplierId);

    List<ExpenseDTO> findByStatus(String status);

    void deleteById(Long id);

}

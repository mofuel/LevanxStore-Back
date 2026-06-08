package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.ExpenseDTO;
import com.levanxstore.domain.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseDTO save(ExpenseDTO dto) {
        if (dto.getDate() == null) {
            dto.setDate(LocalDateTime.now());
        }
        if (dto.getStatus() == null) {
            dto.setStatus("ACTIVE");
        }
        return expenseRepository.save(dto);
    }

    public Optional<ExpenseDTO> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public List<ExpenseDTO> findAll() {
        return expenseRepository.findAll();
    }

    public List<ExpenseDTO> findBySupplierId(Long supplierId) {
        return expenseRepository.findBySupplierId(supplierId);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}

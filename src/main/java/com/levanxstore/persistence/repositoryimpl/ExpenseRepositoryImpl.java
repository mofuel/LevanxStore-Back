package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.ExpenseDTO;
import com.levanxstore.domain.repository.ExpenseRepository;
import com.levanxstore.persistence.crud.ExpenseCrudRepository;
import com.levanxstore.persistence.entity.Expense;
import com.levanxstore.persistence.entity.Supplier;
import com.levanxstore.persistence.mapper.ExpenseMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseCrudRepository crudRepository;
    private final ExpenseMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public ExpenseRepositoryImpl(ExpenseCrudRepository crudRepository, ExpenseMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ExpenseDTO save(ExpenseDTO expenseDTO) {
        Expense entity = mapper.toEntity(expenseDTO);
        if (expenseDTO.getSupplierId() != null) {
            entity.setSupplier(entityManager.getReference(Supplier.class, expenseDTO.getSupplierId()));
        }
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<ExpenseDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ExpenseDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDTO> findBySupplierId(Long supplierId) {
        return crudRepository.findBySupplierId(supplierId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDTO> findByStatus(String status) {
        return crudRepository.findByStatus(Expense.ExpenseStatus.valueOf(status)).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}

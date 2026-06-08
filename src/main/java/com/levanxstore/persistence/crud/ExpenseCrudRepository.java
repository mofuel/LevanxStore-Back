package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseCrudRepository extends JpaRepository<Expense, Long> {

    List<Expense> findBySupplierId(Long supplierId);

    List<Expense> findByStatus(Expense.ExpenseStatus status);

}

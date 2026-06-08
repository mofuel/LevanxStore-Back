package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses", indexes = {
    @Index(name = "idx_expense_supplier", columnList = "supplier_id")
})
public class Expense extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private String description;

    private Integer quantity;

    @Column(precision = 10, scale = 2)
    private BigDecimal unitCost;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExpenseStatus status;

    public enum ExpenseStatus {
        ACTIVE,
        CANCELED
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public LocalDateTime getDate() {return date;}

    public void setDate(LocalDateTime date) {this.date = date;}

    public Supplier getSupplier() {return supplier;}

    public void setSupplier(Supplier supplier) {this.supplier = supplier;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public BigDecimal getUnitCost() {return unitCost;}

    public void setUnitCost(BigDecimal unitCost) {this.unitCost = unitCost;}

    public BigDecimal getTotalAmount() {return totalAmount;}

    public void setTotalAmount(BigDecimal totalAmount) {this.totalAmount = totalAmount;}

    public ExpenseStatus getStatus() {return status;}

    public void setStatus(ExpenseStatus status) {this.status = status;}
}

package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private String description;

    private Integer quantity;

    private Double unitCost;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private ExpenseStatus status;

    public enum ExpenseStatus {
        ACTIVE,
        CANCELED
    }

    //Getters and Setters

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

    public Double getUnitCost() {return unitCost;}

    public void setUnitCost(Double unitCost) {this.unitCost = unitCost;}

    public Double getTotalAmount() {return totalAmount;}

    public void setTotalAmount(Double totalAmount) {this.totalAmount = totalAmount;}

    public ExpenseStatus getStatus() {return status;}

    public void setStatus(ExpenseStatus status) {this.status = status;}
}

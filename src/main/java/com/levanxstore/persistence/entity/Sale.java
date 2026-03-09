package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String customerFirstName;

    private String customerLastName;

    private String customerPhone;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    public enum PaymentMethod {
        CASH,
        CARD,
        TRANSFER
    }

    public enum SaleStatus {
        PAID,
        CANCELED
    }

    //Getters and Setters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public LocalDateTime getDate() {return date;}

    public void setDate(LocalDateTime date) {this.date = date;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}

    public String getCustomerFirstName() {return customerFirstName;}

    public void setCustomerFirstName(String customerFirstName) {this.customerFirstName = customerFirstName;}

    public String getCustomerPhone() {return customerPhone;}

    public void setCustomerPhone(String customerPhone) {this.customerPhone = customerPhone;}

    public String getCustomerLastName() {return customerLastName;}

    public void setCustomerLastName(String customerLastName) {this.customerLastName = customerLastName;}

    public Double getTotalAmount() {return totalAmount;}

    public void setTotalAmount(Double totalAmount) {this.totalAmount = totalAmount;}

    public PaymentMethod getPaymentMethod() {return paymentMethod;}

    public void setPaymentMethod(PaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}

    public SaleStatus getStatus() {return status;}

    public void setStatus(SaleStatus status) {this.status = status;}
}

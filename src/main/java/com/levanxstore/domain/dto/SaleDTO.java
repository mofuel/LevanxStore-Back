package com.levanxstore.domain.dto;

import java.time.LocalDateTime;

public class SaleDTO {

    private Long id;
    private LocalDateTime date;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private Double totalAmount;
    private String paymentMethod;
    private String status;

    //Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getCustomerFirstName() { return customerFirstName; }
    public void setCustomerFirstName(String customerFirstName) { this.customerFirstName = customerFirstName; }
    public String getCustomerLastName() { return customerLastName; }
    public void setCustomerLastName(String customerLastName) { this.customerLastName = customerLastName; }
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

package com.levanxstore.domain.dto;

import java.util.List;

public class CreateSaleRequestDTO {
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private String paymentMethod;
    private List<CreateSaleItemDTO> items;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getCustomerFirstName() { return customerFirstName; }
    public void setCustomerFirstName(String customerFirstName) { this.customerFirstName = customerFirstName; }
    public String getCustomerLastName() { return customerLastName; }
    public void setCustomerLastName(String customerLastName) { this.customerLastName = customerLastName; }
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public List<CreateSaleItemDTO> getItems() { return items; }
    public void setItems(List<CreateSaleItemDTO> items) { this.items = items; }
}

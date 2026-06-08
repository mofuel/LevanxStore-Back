package com.levanxstore.domain.dto;

import java.time.LocalDateTime;

public class LoyaltyAccountDTO {
    private Long id;
    private Long customerId;
    private String customerName;
    private Integer points;
    private String token;
    private LocalDateTime lastPurchaseAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public LocalDateTime getLastPurchaseAt() { return lastPurchaseAt; }
    public void setLastPurchaseAt(LocalDateTime lastPurchaseAt) { this.lastPurchaseAt = lastPurchaseAt; }
}

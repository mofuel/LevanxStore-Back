package com.levanxstore.domain.dto;

import java.math.BigDecimal;

public class MarketingPartnerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal creditsAmount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public BigDecimal getCreditsAmount() { return creditsAmount; }
    public void setCreditsAmount(BigDecimal creditsAmount) { this.creditsAmount = creditsAmount; }
}

package com.levanxstore.domain.dto;

public class MarketingPartnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Double creditsAmount;

    //Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Double getCreditsAmount() { return creditsAmount; }
    public void setCreditsAmount(Double creditsAmount) { this.creditsAmount = creditsAmount; }

    
}

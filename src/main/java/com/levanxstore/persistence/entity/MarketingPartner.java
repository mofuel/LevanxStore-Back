package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marketing_partners")
public class MarketingPartner extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private Double creditsAmount = 0.0;

    //Getters and Setters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public Double getCreditsAmount() {return creditsAmount;}

    public void setCreditsAmount(Double creditsAmount) {this.creditsAmount = creditsAmount;}
}

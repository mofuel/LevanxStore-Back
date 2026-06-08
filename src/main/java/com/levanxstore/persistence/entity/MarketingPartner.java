package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "marketing_partners")
public class MarketingPartner extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal creditsAmount = BigDecimal.ZERO;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public BigDecimal getCreditsAmount() {return creditsAmount;}

    public void setCreditsAmount(BigDecimal creditsAmount) {this.creditsAmount = creditsAmount;}
}

package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loyalty_accounts")
public class LoyaltyAccount extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true, nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Integer points = 0;

    @Column(unique = true)
    private String token;

    private LocalDateTime lastPurchaseAt;

    //Getters and Setters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}

    public Integer getPoints() {return points;}

    public void setPoints(Integer points) {this.points = points;}

    public String getToken() {return token;}

    public void setToken(String token) {this.token = token;}

    public LocalDateTime getLastPurchaseAt() {return lastPurchaseAt;}

    public void setLastPurchaseAt(LocalDateTime lastPurchaseAt) {this.lastPurchaseAt = lastPurchaseAt;}
}

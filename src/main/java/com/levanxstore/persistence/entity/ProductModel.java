package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_models",
        uniqueConstraints = @UniqueConstraint(columnNames = {"brand", "model"}))
public class ProductModel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    //Getters and Setters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}
}

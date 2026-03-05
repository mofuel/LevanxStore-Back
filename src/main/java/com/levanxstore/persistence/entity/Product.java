package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean active = true;

    //Getters and Setters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Boolean getActive() {return active;}

    public void setActive(Boolean active) {this.active = active;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}
}

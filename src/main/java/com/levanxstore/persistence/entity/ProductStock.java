package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_stock",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "model_id"}))
public class ProductStock extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ProductModel model;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double costPrice;

    @Column(nullable = false)
    private Double salePrice;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public ProductModel getModel() {return model;}

    public void setModel(ProductModel model) {this.model = model;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getSalePrice() {return salePrice;}

    public void setSalePrice(Double salePrice) {this.salePrice = salePrice;}

    public Double getCostPrice() {return costPrice;}

    public void setCostPrice(Double costPrice) {this.costPrice = costPrice;}
}

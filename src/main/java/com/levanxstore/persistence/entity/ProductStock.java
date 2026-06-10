package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_stock",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "model_id"}),
        indexes = {
            @Index(name = "idx_product_stock_product", columnList = "product_id"),
            @Index(name = "idx_product_stock_model", columnList = "model_id")
        })
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

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

    private Integer minStock = 0;

    @Version
    private Long version;

    public Long getVersion() { return version; }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public ProductModel getModel() {return model;}

    public void setModel(ProductModel model) {this.model = model;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public BigDecimal getSalePrice() {return salePrice;}

    public void setSalePrice(BigDecimal salePrice) {this.salePrice = salePrice;}

    public BigDecimal getCostPrice() {return costPrice;}

    public void setCostPrice(BigDecimal costPrice) {this.costPrice = costPrice;}

    public Integer getMinStock() { return minStock; }

    public void setMinStock(Integer minStock) { this.minStock = minStock; }
}

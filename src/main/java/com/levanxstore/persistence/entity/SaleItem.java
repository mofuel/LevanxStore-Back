package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sale_items")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_stock_id", nullable = false)
    private ProductStock productStock;

    private Integer quantity;

    private Double unitPrice;

    private Double subtotal;

    //Getters and Setters
    
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Sale getSale() {return sale;}

    public void setSale(Sale sale) {this.sale = sale;}

    public ProductStock getProductStock() {return productStock;}

    public void setProductStock(ProductStock productStock) {this.productStock = productStock;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getUnitPrice() {return unitPrice;}

    public void setUnitPrice(Double unitPrice) {this.unitPrice = unitPrice;}

    public Double getSubtotal() {return subtotal;}

    public void setSubtotal(Double subtotal) {this.subtotal = subtotal;}
}

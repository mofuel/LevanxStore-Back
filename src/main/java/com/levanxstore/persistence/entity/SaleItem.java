package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sale_items", indexes = {
    @Index(name = "idx_sale_item_sale", columnList = "sale_id"),
    @Index(name = "idx_sale_item_stock", columnList = "product_stock_id")
})
public class SaleItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_stock_id", nullable = false)
    private ProductStock productStock;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discountAmount = BigDecimal.ZERO;


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Sale getSale() {return sale;}

    public void setSale(Sale sale) {this.sale = sale;}

    public ProductStock getProductStock() {return productStock;}

    public void setProductStock(ProductStock productStock) {this.productStock = productStock;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public BigDecimal getUnitPrice() {return unitPrice;}

    public void setUnitPrice(BigDecimal unitPrice) {this.unitPrice = unitPrice;}

    public BigDecimal getSubtotal() {return subtotal;}

    public void setSubtotal(BigDecimal subtotal) {this.subtotal = subtotal;}

    public BigDecimal getDiscountAmount() { return discountAmount; }

    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
}

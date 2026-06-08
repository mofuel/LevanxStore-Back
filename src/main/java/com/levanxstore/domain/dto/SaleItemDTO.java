package com.levanxstore.domain.dto;

public class SaleItemDTO {

    private Long id;
    private Long saleId;
    private Long productStockId;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;

    //Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSaleId() { return saleId; }
    public void setSaleId(Long saleId) { this.saleId = saleId; }
    public Long getProductStockId() { return productStockId; }
    public void setProductStockId(Long productStockId) { this.productStockId = productStockId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}

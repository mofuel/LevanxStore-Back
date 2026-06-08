package com.levanxstore.domain.dto;

import java.math.BigDecimal;

public class ProductStockDTO {
    private Long id;
    private Long productId;
    private String productName;
    private Long modelId;
    private String modelBrand;
    private String modelName;
    private Integer quantity;
    private BigDecimal costPrice;
    private BigDecimal salePrice;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }
    public String getModelBrand() { return modelBrand; }
    public void setModelBrand(String modelBrand) { this.modelBrand = modelBrand; }
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getCostPrice() { return costPrice; }
    public void setCostPrice(BigDecimal costPrice) { this.costPrice = costPrice; }
    public BigDecimal getSalePrice() { return salePrice; }
    public void setSalePrice(BigDecimal salePrice) { this.salePrice = salePrice; }
}

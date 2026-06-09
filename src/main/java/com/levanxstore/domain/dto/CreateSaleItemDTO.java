package com.levanxstore.domain.dto;

import java.math.BigDecimal;

public class CreateSaleItemDTO {
    private Long productStockId;
    private Integer quantity;
    private BigDecimal discountAmount = BigDecimal.ZERO;

    public Long getProductStockId() { return productStockId; }
    public void setProductStockId(Long productStockId) { this.productStockId = productStockId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
}

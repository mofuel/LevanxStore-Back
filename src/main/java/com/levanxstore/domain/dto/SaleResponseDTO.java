package com.levanxstore.domain.dto;

import java.util.List;

public class SaleResponseDTO {
    private SaleDTO sale;
    private List<String> lowStockAlerts;

    public SaleResponseDTO() {}

    public SaleResponseDTO(SaleDTO sale, List<String> lowStockAlerts) {
        this.sale = sale;
        this.lowStockAlerts = lowStockAlerts;
    }

    public SaleDTO getSale() { return sale; }
    public void setSale(SaleDTO sale) { this.sale = sale; }
    public List<String> getLowStockAlerts() { return lowStockAlerts; }
    public void setLowStockAlerts(List<String> lowStockAlerts) { this.lowStockAlerts = lowStockAlerts; }
}

package com.levanxstore.domain.dto;

import java.math.BigDecimal;

public class InvestorReportDTO {
    private Long id;
    private Long investorId;
    private String investorName;
    private String period;
    private BigDecimal totalSales;
    private BigDecimal totalProductCost;
    private BigDecimal netProfit;
    private BigDecimal investorPercentage;
    private BigDecimal investorProfit;
    private BigDecimal accumulatedProfit;
    private BigDecimal targetAmount;
    private BigDecimal remainingToRecover;
    private BigDecimal amountPaid;
    private BigDecimal pendingBalance;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public String getInvestorName() { return investorName; }
    public void setInvestorName(String investorName) { this.investorName = investorName; }
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public BigDecimal getTotalProductCost() { return totalProductCost; }
    public void setTotalProductCost(BigDecimal totalProductCost) { this.totalProductCost = totalProductCost; }
    public BigDecimal getNetProfit() { return netProfit; }
    public void setNetProfit(BigDecimal netProfit) { this.netProfit = netProfit; }
    public BigDecimal getInvestorPercentage() { return investorPercentage; }
    public void setInvestorPercentage(BigDecimal investorPercentage) { this.investorPercentage = investorPercentage; }
    public BigDecimal getInvestorProfit() { return investorProfit; }
    public void setInvestorProfit(BigDecimal investorProfit) { this.investorProfit = investorProfit; }
    public BigDecimal getAccumulatedProfit() { return accumulatedProfit; }
    public void setAccumulatedProfit(BigDecimal accumulatedProfit) { this.accumulatedProfit = accumulatedProfit; }
    public BigDecimal getTargetAmount() { return targetAmount; }
    public void setTargetAmount(BigDecimal targetAmount) { this.targetAmount = targetAmount; }
    public BigDecimal getRemainingToRecover() { return remainingToRecover; }
    public void setRemainingToRecover(BigDecimal remainingToRecover) { this.remainingToRecover = remainingToRecover; }
    public BigDecimal getAmountPaid() { return amountPaid; }
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; }
    public BigDecimal getPendingBalance() { return pendingBalance; }
    public void setPendingBalance(BigDecimal pendingBalance) { this.pendingBalance = pendingBalance; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

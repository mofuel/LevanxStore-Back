package com.levanxstore.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "investor_reports", indexes = {
    @Index(name = "idx_report_investor", columnList = "investor_id")
})
public class InvestorReport extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    private String period; // ejemplo 2025-01

    @Column(precision = 14, scale = 2)
    private BigDecimal totalSales;

    @Column(precision = 14, scale = 2)
    private BigDecimal totalProductCost;

    @Column(precision = 14, scale = 2)
    private BigDecimal netProfit;

    @Column(precision = 5, scale = 2)
    private BigDecimal investorPercentage;

    @Column(precision = 14, scale = 2)
    private BigDecimal investorProfit;

    @Column(precision = 14, scale = 2)
    private BigDecimal accumulatedProfit;

    @Column(precision = 14, scale = 2)
    private BigDecimal targetAmount;

    @Column(precision = 14, scale = 2)
    private BigDecimal remainingToRecover;

    @Column(precision = 14, scale = 2)
    private BigDecimal amountPaid;

    @Column(precision = 14, scale = 2)
    private BigDecimal pendingBalance;

    @Column(length = 500)
    private String notes;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Investor getInvestor() {return investor;}

    public void setInvestor(Investor investor) {this.investor = investor;}

    public String getPeriod() {return period;}

    public void setPeriod(String period) {this.period = period;}

    public BigDecimal getTotalSales() {return totalSales;}

    public void setTotalSales(BigDecimal totalSales) {this.totalSales = totalSales;}

    public BigDecimal getTotalProductCost() {return totalProductCost;}

    public void setTotalProductCost(BigDecimal totalProductCost) {this.totalProductCost = totalProductCost;}

    public BigDecimal getNetProfit() {return netProfit;}

    public void setNetProfit(BigDecimal netProfit) {this.netProfit = netProfit;}

    public BigDecimal getInvestorPercentage() {return investorPercentage;}

    public void setInvestorPercentage(BigDecimal investorPercentage) {this.investorPercentage = investorPercentage;}

    public BigDecimal getInvestorProfit() {return investorProfit;}

    public void setInvestorProfit(BigDecimal investorProfit) {this.investorProfit = investorProfit;}

    public BigDecimal getAccumulatedProfit() {return accumulatedProfit;}

    public void setAccumulatedProfit(BigDecimal accumulatedProfit) {this.accumulatedProfit = accumulatedProfit;}

    public BigDecimal getTargetAmount() {return targetAmount;}

    public void setTargetAmount(BigDecimal targetAmount) {this.targetAmount = targetAmount;}

    public BigDecimal getRemainingToRecover() {return remainingToRecover;}

    public void setRemainingToRecover(BigDecimal remainingToRecover) {this.remainingToRecover = remainingToRecover;}

    public BigDecimal getAmountPaid() {return amountPaid;}

    public void setAmountPaid(BigDecimal amountPaid) {this.amountPaid = amountPaid;}

    public BigDecimal getPendingBalance() {return pendingBalance;}

    public void setPendingBalance(BigDecimal pendingBalance) {this.pendingBalance = pendingBalance;}

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}
}

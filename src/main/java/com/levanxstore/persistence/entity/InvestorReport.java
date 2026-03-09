package com.levanxstore.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "investor_reports")
public class InvestorReport extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    private String period; // ejemplo 2025-01

    private Double totalSales;

    private Double totalProductCost;

    private Double netProfit;

    private Double investorPercentage;

    private Double investorProfit;

    private Double accumulatedProfit;

    private Double targetAmount;

    private Double remainingToRecover;

    private Double amountPaid;

    private Double pendingBalance;

    private String notes;

    //Getters and Setters


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Investor getInvestor() {return investor;}

    public void setInvestor(Investor investor) {this.investor = investor;}

    public String getPeriod() {return period;}

    public void setPeriod(String period) {this.period = period;}

    public Double getTotalSales() {return totalSales;}

    public void setTotalSales(Double totalSales) {this.totalSales = totalSales;}

    public Double getTotalProductCost() {return totalProductCost;}

    public void setTotalProductCost(Double totalProductCost) {this.totalProductCost = totalProductCost;}

    public Double getNetProfit() {return netProfit;}

    public void setNetProfit(Double netProfit) {this.netProfit = netProfit;}

    public Double getInvestorPercentage() {return investorPercentage;}

    public void setInvestorPercentage(Double investorPercentage) {this.investorPercentage = investorPercentage;}

    public Double getInvestorProfit() {return investorProfit;}

    public void setInvestorProfit(Double investorProfit) {this.investorProfit = investorProfit;}

    public Double getAccumulatedProfit() {return accumulatedProfit;}

    public void setAccumulatedProfit(Double accumulatedProfit) {this.accumulatedProfit = accumulatedProfit;}

    public Double getTargetAmount() {return targetAmount;}

    public void setTargetAmount(Double targetAmount) {this.targetAmount = targetAmount;}

    public Double getRemainingToRecover() {return remainingToRecover;}

    public void setRemainingToRecover(Double remainingToRecover) {this.remainingToRecover = remainingToRecover;}

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}

    public Double getAmountPaid() {return amountPaid;}

    public void setAmountPaid(Double amountPaid) {this.amountPaid = amountPaid;}

    public Double getPendingBalance() {return pendingBalance;}

    public void setPendingBalance(Double pendingBalance) {this.pendingBalance = pendingBalance;}
}

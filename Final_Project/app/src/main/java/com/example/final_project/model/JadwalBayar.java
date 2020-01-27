package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class JadwalBayar {
    @SerializedName("id")
    Integer id;
    @SerializedName("trxId")
    String trxId;
    @SerializedName("accountId")
    String accountId;
    @SerializedName("installmentNo")
    Integer installmentNo;
    @SerializedName("principal")
    BigDecimal principal;
    @SerializedName("profitShare")
    BigDecimal profitShare;
    @SerializedName("scheduleDate")
    String scheduleDate;
    @SerializedName("paymentDate")
    String paymentDate;
    @SerializedName("paymentStatement")
    String paymentStatement;
    @SerializedName("paid")
    Boolean paid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getInstallmentNo() {
        return installmentNo;
    }

    public void setInstallmentNo(Integer installmentNo) {
        this.installmentNo = installmentNo;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getProfitShare() {
        return profitShare;
    }

    public void setProfitShare(BigDecimal profitShare) {
        this.profitShare = profitShare;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatement() {
        return paymentStatement;
    }

    public void setPaymentStatement(String paymentStatement) {
        this.paymentStatement = paymentStatement;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}

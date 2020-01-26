package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class JadwalBayar {
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
}

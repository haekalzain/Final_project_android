package com.example.final_project.model;

import android.icu.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AkunPeminjaman {

    @SerializedName("accountNo")
    String accountNo;
    @SerializedName("customerId")
    String customerId;
    @SerializedName("plafon")
    Double plafon;
    @SerializedName("tenor")
    Integer tenor;
    @SerializedName("margin")
    Double margin;
    @SerializedName("disbursementDate")
    String disbursementDate;
    @SerializedName("dueDate")
    String dueDate;
    @SerializedName("scheduleList")
    List<JadwalBayar> jadwalBayarList;

    public Double getPlafon() {
        return plafon;
    }

    public void setPlafon(Double plafon) {
        this.plafon = plafon;
    }

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }



    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<JadwalBayar> getJadwalBayarList() {
        return jadwalBayarList;
    }

    public void setJadwalBayarList(List<JadwalBayar> jadwalBayarList) {
        this.jadwalBayarList = jadwalBayarList;
    }
}

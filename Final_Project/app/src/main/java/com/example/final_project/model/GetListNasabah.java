package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetListNasabah {

    @SerializedName("code")
    Integer code;
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    DataNasabah listDataNasabah;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public DataNasabah getListDataNasabah() {
        return listDataNasabah;
    }

    public void setListDataNasabah(DataNasabah listDataNasabah) {
        this.listDataNasabah = listDataNasabah;
    }
}

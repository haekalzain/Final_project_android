package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class baseResponse {
//    @SerializedName("data")
//    List<co> listco;
    @SerializedName("code")
    Integer code;
    @SerializedName("message")
    String message;
    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//    public List<co> getListco() {
//        return listco;
//    }
//
//    public void setListco(List<co> listco) {
//        this.listco = listco;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

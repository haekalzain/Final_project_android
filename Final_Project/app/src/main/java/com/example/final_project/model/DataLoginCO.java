package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class DataLoginCO {
    @SerializedName("message")
    String message;
    @SerializedName("token")
    String token;
    @SerializedName("data")
    DataCo dataCo;

    public DataCo getDataCo() {
        return dataCo;
    }

    public void setDataCo(DataCo dataCo) {
        this.dataCo = dataCo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

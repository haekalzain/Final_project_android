package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponMiddleware {

    @SerializedName("status")
    String status;
    @SerializedName("message")
    ResponMiddleware2 message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponMiddleware2 getMessage() {
        return message;
    }

    public void setMessage(ResponMiddleware2 message) {
        this.message = message;
    }
}

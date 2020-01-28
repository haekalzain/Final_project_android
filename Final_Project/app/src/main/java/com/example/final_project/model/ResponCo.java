package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class ResponCo {
    @SerializedName("status")
    String status;
    @SerializedName("code")
    Integer code;
    @SerializedName("messagae")
    String messagae;
    @SerializedName("data")
    DataCo co;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessagae() {
        return messagae;
    }

    public void setMessagae(String messagae) {
        this.messagae = messagae;
    }

    public DataCo getCo() {
        return co;
    }

    public void setCo(DataCo co) {
        this.co = co;
    }
}

package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class DataCo {
    @SerializedName("emp_id")
    Integer emp_id;
    @SerializedName("nik")
    String nik;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("address")
    String addres;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}

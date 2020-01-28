package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class Nasabah {
    @SerializedName("id")
    private String id;
    @SerializedName("customer_no")
    private String customer_no;
    @SerializedName("customer_nik")
    private String customer_nik;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private String address;
    @SerializedName("phone")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomer_nik() {
        return customer_nik;
    }

    public void setCustomer_nik(String customer_nik) {
        this.customer_nik = customer_nik;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

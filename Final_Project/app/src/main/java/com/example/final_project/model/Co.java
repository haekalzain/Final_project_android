package com.example.final_project.model;

import com.google.gson.annotations.SerializedName;

public class Co {
    @SerializedName("email")
    String email;
    @SerializedName("nama")
    String nama;
    @SerializedName("nik")
    String nik;
    @SerializedName("role")
    String role;
    @SerializedName("token")
    String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

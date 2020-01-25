package com.example.final_project.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.example.final_project.R;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    ImageButton Nasabah, Finance, Payment, Setting;
    TextView nama, nik;
    ApiInterface mApiInterface;
    Preference preference;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById();
        onClick();
        initData();
    }

    void initData(){
        nama.setText(new Preference().getName(getApplicationContext()));
        nik.setText(new Preference().getNik(getApplicationContext()));
    }

    void findViewById(){
        Nasabah = findViewById(R.id.btnNasabah);
        Finance = findViewById(R.id.btnFinance);
        Payment = findViewById(R.id.btnPayment);
        Setting = findViewById(R.id.btnSetting);
        nama = findViewById(R.id.NamaCo);
        nik = findViewById(R.id.NikCo);
    }


    void onClick() {
        //forgotPassword
        Nasabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NasabahActivity.class);
                startActivity(intent);
            }
        });

        Finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PembayaranActivity.class);
                startActivity(intent);
            }
        });

        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PeminjamanActivity.class);
                startActivity(intent);
            }
        });

        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}

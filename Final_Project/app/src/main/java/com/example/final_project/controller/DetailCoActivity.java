package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.final_project.R;

public class DetailCoActivity extends AppCompatActivity {

    TextView nama,nik;
    Button ubah,out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_co);

        findViewById();
        OnClick();
    }
    void findViewById(){
        nama = findViewById(R.id.namaCoTv);
        nik=findViewById(R.id.nikCoTv);
        ubah=findViewById(R.id.btnUbah);
        out=findViewById(R.id.btnOut);
    }

    void OnClick(){
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}

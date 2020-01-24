package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.final_project.R;

public class SettingActivity extends AppCompatActivity {

    EditText nama,email,address;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        findViewById();
        OnClick();

    }

    void findViewById(){
        nama = findViewById(R.id.namaCoTxt);
        email=findViewById(R.id.emailCoTxt);
        address=findViewById(R.id.addressCoTxt);
        save=findViewById(R.id.btnSave);
    }

    void OnClick(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, DetailCoActivity.class);
                startActivity(intent);
            }
        });

    }
}

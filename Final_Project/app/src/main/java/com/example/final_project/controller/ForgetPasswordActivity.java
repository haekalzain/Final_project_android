package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button telepon;
    TextView noTlp;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        findViewById();
        OnClick();
    }
    void findViewById(){
        back = findViewById(R.id.back);
        noTlp = findViewById(R.id.Notelp_Tv);
        telepon = findViewById(R.id.telponbtn);
    }

    void OnClick(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }
    protected void makeCall(){
        String phoneNo = "1500300";
        if(!TextUtils.isEmpty(phoneNo)) {
            String dial = "tel:" + phoneNo;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
        }else {
            Toast.makeText(ForgetPasswordActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
        }
    }
}

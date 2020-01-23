package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.fragment.DaftarPeminjamanFragment;

public class DetailNasabahActivity extends AppCompatActivity {
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nasabah);
        findViewById();
        initData();

    }

     void findViewById() {
    }

    void initData() {
         Bundle bundle = getIntent().getExtras();
         id = bundle.getString("id");
         Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
    }
}

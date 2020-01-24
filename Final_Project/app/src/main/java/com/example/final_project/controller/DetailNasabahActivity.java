package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.fragment.DaftarPeminjamanFragment;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;

public class DetailNasabahActivity extends AppCompatActivity {
//String id;
TextView idnasabahupdate;
EditText namanasabahupdate,emailnasabahupdate,alamatnasabahupdate,nomorhpnasabahupdate;
Button btnupdatenasabah;
ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nasabah);
        findViewById();
        initData();
        onClick();
    }

     void onClick() {
        btnupdatenasabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void findViewById() {
        btnupdatenasabah=findViewById(R.id.btnnasabahupadte);
        emailnasabahupdate=findViewById(R.id.emailnasabahupdate);
        namanasabahupdate=findViewById(R.id.namanasabahupdate);
        nomorhpnasabahupdate=findViewById(R.id.nomorhpnasabahupdate);
        alamatnasabahupdate=findViewById(R.id.alamatnasabahupdate);
        idnasabahupdate=findViewById(R.id.idnasabahupdate);

    }

    void initData() {
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
//         Bundle bundle = getIntent().getExtras();
//         id = bundle.getString("id");
//         Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
    }
}

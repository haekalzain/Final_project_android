package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.final_project.R;
import com.example.final_project.model.DataCo;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.model.ResponCo;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingActivity extends AppCompatActivity {

    private String id;
    private DataCo dataco = new DataCo();
    LinearLayout back;
    EditText nama,nik,address,email;
    Button save;
    JsonObject O;
    String Name,Nik,Address,Email;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mApiInterface= ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);

        findViewById();
        OnClick();
        initData();

    }

    void initData(){
        Bundle bundle = getIntent().getExtras();
        Name = bundle.getString("name");
        Nik = bundle.getString("nik");
        Address = bundle.getString("address");
        Email = bundle.getString("email");

        nama.setText(Name);
        nik.setText(Nik);
        address.setText(Address);
        email.setText(Email);
    }

    void findViewById(){
        nama = findViewById(R.id.namaCoTxt);
        nik=findViewById(R.id.NikCoTxt);
        address=findViewById(R.id.addressCoTxt);
        email=findViewById(R.id.emailCoTxt);
        save=findViewById(R.id.btnSave);
        back=findViewById(R.id.back);
    }

    void OnClick(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, DetailCoActivity.class);
                startActivity(intent);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    O = new JsonObject();
                    O.addProperty("name", nama.getText().toString());
                    O.addProperty("address", address.getText().toString());
                    O.addProperty("email", email.getText().toString());
                    Log.e("aaa", O.toString());
                    Call<ResponCo> CoCall = mApiInterface.putCo( Nik, O);
                    CoCall.enqueue(new Callback<ResponCo>() {
                        @Override
                        public void onResponse(Call<ResponCo> call, Response<ResponCo> response) {
                            if (response.isSuccessful()) {
                                dataco = response.body().getCo();
                                nama.setText(dataco.getName());
                                address.setText(dataco.getAddres());
                                email.setText(dataco.getEmail());
                                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponCo> call, Throwable t) {
                            Log.e("ccc", "cccc");
                        }
                    });
                } catch (Exception e) {
                    System.out.println("error" + e.toString());
                }
            }
        });

    }
}

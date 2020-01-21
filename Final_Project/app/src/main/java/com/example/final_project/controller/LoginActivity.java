package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.model.BaseResponse;

import com.example.final_project.model.Co;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    EditText nik,password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById();
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
        onClick();

    }

     void onClick() {
    btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            JsonObject o = new JsonObject();
            o.addProperty("nik",nik.getText().toString());
            o.addProperty("password",password.getText().toString());
            Call<BaseResponse> nasabahcalled = mApiInterface.createNasabah(o);
            nasabahcalled.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                    if(response.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this,NasabahActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();

                    }


                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                }
            });

        }
    });

    }

    void findViewById() {
        nik=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnlogin);

    }
}

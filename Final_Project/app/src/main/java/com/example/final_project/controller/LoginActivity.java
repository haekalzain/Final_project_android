package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.model.baseResponse;
import com.example.final_project.res.ApiClient;
import com.example.final_project.res.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText username, password;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById();
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
        onClick();
    }

    void findViewById(){
        login = findViewById(R.id.loginbtn);
        username = findViewById(R.id.usernametxt);
        password = findViewById(R.id.passwordtxt);
    }

    void onClick() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject json = new JsonObject();
                json.addProperty("nik", username.getText().toString());
                json.addProperty("password", password.getText().toString());
                Call<baseResponse> coCalled = mApiInterface.postCo(json);

                coCalled.enqueue(new Callback<baseResponse>() {
                    @Override
                    public void onResponse(Call<baseResponse> call, Response<baseResponse> response) {
                        if (response.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<baseResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}

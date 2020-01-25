package com.example.final_project.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.example.final_project.R;
import com.example.final_project.model.DataLoginCO;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.example.final_project.util.Preference;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button login;
    LinearLayout forgotPassword;
    EditText username, password;
    ApiInterface mApiInterface;
    Preference preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById();
       mApiInterface= ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
        onClick();
    }

    void findViewById(){
        login = findViewById(R.id.loginbtn);
        username = findViewById(R.id.usernametxt);
        password = findViewById(R.id.passwordtxt);
        forgotPassword = findViewById(R.id.forgotPassword);
    }

    void onClick() {
        //forgotPassword
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent( LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject json = new JsonObject();
                json.addProperty("username", username.getText().toString());
                json.addProperty("password", password.getText().toString());
                Call<DataLoginCO> coCalled = mApiInterface.postCo(json);

                coCalled.enqueue(new Callback<DataLoginCO>() {
                    @Override
                    public void onResponse(Call<DataLoginCO> call, Response<DataLoginCO> response) {
//                        Log.d("respon ",response.message().toString());
                        if (response.isSuccessful()) {
                            String JWTEncoded = response.body().getToken();
                            try {
                                String[] split = JWTEncoded.split("\\.");
                                Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
                                Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
                            } catch (UnsupportedEncodingException e) {
                                //Error
                            }
                            JWT parsedJWT = new JWT(JWTEncoded);
                            Claim nameMetaData = parsedJWT.getClaim("name");
                            String nameValue = nameMetaData.asString();


                            Claim nikMetaData = parsedJWT.getClaim("nik");
                            String nikValue = nikMetaData.asString();
                            Log.d("hello ",nikValue);

                            preference = new Preference();
                            preference.setToken(getBaseContext(),JWTEncoded);
                            preference.setName(getBaseContext(),nameValue);
                            preference.setNik(getBaseContext(), nikValue);




                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);



                        } else {
                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DataLoginCO> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    private static String getJson(String strEncoded) throws UnsupportedEncodingException{
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }

}

package com.example.final_project.res;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.final_project.util.Preference;

import java.io.IOException;
import java.lang.ref.Reference;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.30.94:3000";
    public static String API_KEY = "xxx123";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(final Context context){

        if (retrofit==null) {
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
//                            .addHeader("Authorization",  new Preference().getName(context))
                            .build();
                    return chain.proceed(request);
                }
            }).build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

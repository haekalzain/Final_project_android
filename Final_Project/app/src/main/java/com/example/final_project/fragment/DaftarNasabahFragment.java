package com.example.final_project.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.controller.NasabahActivity;
import com.example.final_project.model.GetAndPostNasabah;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DaftarNasabahFragment extends Fragment {
   Button btnregistnasabah;
   EditText createnamanasabah,createemailnasabah,createnohpnasabah,createalamatnasabah;
   TextView createnikco;
    ApiInterface mApiInterface;
    LinearLayout fragmentdaftarnasabah;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_daftar_nasabah, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        initData();
        onClick();
    }

    private void initData() {
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
    }

    void onClick() {
        btnregistnasabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObject o= new JsonObject();
                o.addProperty("name",createnamanasabah.getText().toString());
                o.addProperty("address",createalamatnasabah.getText().toString());
                o.addProperty("email",createemailnasabah.getText().toString());
                o.addProperty("phone",createnohpnasabah.getText().toString());
                o.addProperty("customer_nik",createnikco.getText().toString());

                Log.e("isi json",o.toString());

                Call<GetAndPostNasabah> nasabahCalled = mApiInterface.createNasabah(o);
                nasabahCalled.enqueue(new Callback<GetAndPostNasabah>() {
                    @Override
                    public void onResponse(Call<GetAndPostNasabah> call, Response<GetAndPostNasabah> response) {
                        Log.e("zzzz",response.code()+"");
                        if(response.code()== 400){
                            Toast.makeText(getActivity().getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();

                        }
                        else{
                            Snackbar.make(getActivity().findViewById(R.id.fragmentdaftarnasabah),
                                    "text to show", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(getActivity().getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                            Intent a = new Intent(getActivity(), NasabahActivity.class);
                            startActivity(a);
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetAndPostNasabah> call, Throwable t) {
                        Log.e("Error :",t.toString());
                    }
                });
            }
        });
    }

    void findViewById(View view) {
        btnregistnasabah=(Button) view.findViewById(R.id.btnregistnasabah);
        createnamanasabah=(EditText) view.findViewById(R.id.createnamanasabah);
        createemailnasabah=(EditText) view.findViewById(R.id.createemailnasabah);
        createnohpnasabah = (EditText) view.findViewById(R.id.createnohpnasabah);
        createalamatnasabah = (EditText) view.findViewById(R.id.createalamatnasabah);
        createnikco = (TextView) view.findViewById(R.id.createnikco);


    }
}

package com.example.final_project.fragment;

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
import android.widget.ListView;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.adapter.ListPeminjamanAdapter;
import com.example.final_project.adapter.NasabahAdapter;
import com.example.final_project.model.AkunPeminjaman;
import com.example.final_project.model.GetAkunNasabah;
import com.example.final_project.model.Nasabah;
import com.example.final_project.model.ResponMiddleware;
import com.example.final_project.rest.ApiClient;
import com.example.final_project.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListPeminjamanFragment extends Fragment {
    ApiInterface mApiInterface;
    EditText searchpeminjaman;
    Button btnsearchakunnasabah;
    TextView WktuPembayaranTv,TglPencairanTv,RataPeminjamanTv,BtsanCicilanTv,JmlPeminjamanTv,idNasabahTv;
    AkunPeminjaman akunPeminjaman = new AkunPeminjaman();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mApiInterface= ApiClient.getClient(getContext()).create(ApiInterface.class);
        findViewById(view);
        OnClick();
        btnsearchakunnasabah.callOnClick();
    }

    void OnClick() {
        btnsearchakunnasabah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("aaaa","aaaaa");
            Call<GetAkunNasabah> responMiddlewareCall = mApiInterface.getAkunNasabah();
            Log.e("bbbb",responMiddlewareCall.toString());
            responMiddlewareCall.enqueue(new Callback<GetAkunNasabah>() {
                @Override
                public void onResponse(Call<GetAkunNasabah> call, Response<GetAkunNasabah> response) {
                    Log.e("gggg",response.body().getAkunPeminjaman().getAccountNo());
                    akunPeminjaman = response.body().getAkunPeminjaman();
                    WktuPembayaranTv.setText(response.body().getAkunPeminjaman().getDueDate());
                    TglPencairanTv.setText(akunPeminjaman.getDisbursementDate());
                    JmlPeminjamanTv.setText(akunPeminjaman.getPlafon()+"");
                }

                @Override
                public void onFailure(Call<GetAkunNasabah> call, Throwable t) {

                }
            });
        }
    });


    }


    void findViewById(View view) {
        btnsearchakunnasabah= (Button) view.findViewById(R.id.seacrhakunnasabah);
        searchpeminjaman =(EditText) view.findViewById(R.id.searchpeminjaman);
        WktuPembayaranTv =(TextView) view.findViewById(R.id.WktuPembayaranTv);
        TglPencairanTv =(TextView) view.findViewById(R.id.TglPencairanTv);
        RataPeminjamanTv =(TextView) view.findViewById(R.id.RataPeminjamanTv);
        BtsanCicilanTv =(TextView) view.findViewById(R.id.BtsanCicilanTv);
        JmlPeminjamanTv =(TextView) view.findViewById(R.id.JmlPeminjamanTv);
        idNasabahTv =(TextView) view.findViewById(R.id.idNasabahTv);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_peminjaman, container, false);
    }


}

package com.example.final_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.model.AkunPeminjaman;
import com.example.final_project.model.JadwalBayar;

import java.util.List;

public class ListPeminjamanAdapter extends BaseAdapter {
    Context context;
    private List<JadwalBayar> list;

    public ListPeminjamanAdapter (Context context,List<JadwalBayar> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(this.context);
            convertView=inflater.inflate(R.layout.item_peminjaman,null);
        }

        JadwalBayar jadwalBayar = list.get(position);
        TextView kodebayar=(TextView) convertView.findViewById(R.id.trxid);
        kodebayar.setText(jadwalBayar.getTrxId());
        TextView scheduledate=(TextView)convertView.findViewById(R.id.scdlDate);
        scheduledate.setText(jadwalBayar.getScheduleDate());
        TextView paid =(TextView)convertView.findViewById(R.id.paid);
        scheduledate.setText(jadwalBayar.getPaid().toString());
        String jmlBayar = String.valueOf(jadwalBayar.getProfitShare().add(jadwalBayar.getPrincipal()));
        TextView jumlahbayar=(TextView)convertView.findViewById(R.id.jmlBayar);
        jumlahbayar.setText(jmlBayar);

        return convertView;
    }
}

package com.example.final_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.final_project.R;
import com.example.final_project.model.AkunPeminjaman;
import com.example.final_project.model.Nasabah;

import java.util.List;

public class ListPeminjamanAdapter extends BaseAdapter {
    Context context;
    private List<AkunPeminjaman> list;

    public ListPeminjamanAdapter (Context context,List<AkunPeminjaman> list){
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
        return convertView;
    }
}

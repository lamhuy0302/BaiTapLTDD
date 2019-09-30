package com.example.gkapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Sinhvien> lstSV;
    private Activity act;
    private int item;

    public CustomAdapter( Activity act,ArrayList<Sinhvien> lstSV, int item) {
        this.lstSV = lstSV;
        this.act = act;
        this.item = item;
    }

    @Override
    public int getCount() {
        return lstSV.size();
    }

    @Override
    public Object getItem(int i) {
        return lstSV.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = act.getLayoutInflater();
        view = layoutInflater.inflate(item,null);
        ImageView ivPic = view.findViewById(R.id.imPic);
        TextView tvTen = view.findViewById(R.id.tvTen);

        ivPic.setImageResource(lstSV.get(i).getPic());
        tvTen.setText(lstSV.get(i).getTen());
        return view;
    }
}

package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    public CustomAdapter(Context context, List<Sach> lstSach) {
        this.context = context;
        this.lstSach = lstSach;
    }

    private Context context;
    private List<Sach> lstSach;

    @Override
    public int getCount() {
        return lstSach.size();
    }

    @Override
    public Object getItem(int i) {
        return lstSach.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tvId);
            viewHolder.tvTen = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sach s = lstSach.get(position);
        viewHolder.tvId.setText(String.valueOf(s.getId()));
        viewHolder.tvTen.setText(s.getTen());
        return convertView;
    }
    public class ViewHolder {
        TextView tvId,tvTen;
    }

}

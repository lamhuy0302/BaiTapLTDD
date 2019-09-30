package com.example.gkapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ControlFrag extends Fragment {
    ArrayList<Sinhvien> lstSV;
    ListView lsv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_layout,container,false);

        lstSV = new ArrayList<Sinhvien>();

        lsv = view.findViewById(R.id.ListSV);

        lstSV.add(new Sinhvien(R.mipmap.ic_launcher_round,"Huy"));
        lstSV.add(new Sinhvien(R.mipmap.ic_launcher_round,"Kiet"));
        lstSV.add(new Sinhvien(R.mipmap.ic_launcher_round,"Hoang"));

        lsv.setAdapter(new CustomAdapter(getActivity(), lstSV, R.layout.item_layout));

        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sinhvien sv = lstSV.get(i);
                Bundle bundle = new Bundle();

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    FragItem fragItem = (FragItem)getFragmentManager().findFragmentById(R.id.fragment2);
                    fragItem.ivPic.setImageResource(sv.getPic());
                    fragItem.tvTen.setText(sv.getTen());
                }else {
                    bundle.putInt("pic",sv.getPic());
                    bundle.putString("name",sv.getTen());

                    Intent intent = new Intent(getActivity(),Info.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        return view;
    }
}

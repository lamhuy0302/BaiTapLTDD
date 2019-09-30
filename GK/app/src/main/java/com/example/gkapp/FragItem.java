package com.example.gkapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragItem extends Fragment {
    ImageView ivPic;
    TextView tvTen;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_layout,container,false);
        ivPic = view.findViewById(R.id.imPic);
        tvTen = view.findViewById(R.id.tvTen);
        return view;
    }
}

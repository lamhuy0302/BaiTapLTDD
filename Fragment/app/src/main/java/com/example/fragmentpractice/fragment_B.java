package com.example.fragmentpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_B extends Fragment {
    TextView b;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        b=(TextView) view.findViewById(R.id.tvA);
        return view;
    }
    public void showText(String text) {
        b.setText(text);
    }}

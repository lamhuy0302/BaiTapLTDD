package com.example.fragmentlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

public class fragment extends ListFragment {
    String[] arr = {"Nguyen Van A","Nguyen Van B"};
    ArrayAdapter adt;
}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adt = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arr);
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        set
        return view;
}

package com.example.sqlite_listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Data data;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new Data(this);

        //lv = findViewById(R.id.lv);
        data.create();
        Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
       // ArrayAdapter<SinhVien> arrayAdapter = new ArrayAdapter<SinhVien>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,data.getAll());
        //lv.setAdapter(arrayAdapter);
        //arrayAdapter.notifyDataSetChanged();
    }
}

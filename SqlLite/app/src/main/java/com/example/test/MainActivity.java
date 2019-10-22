package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DB db;
    ListView lv;
    ArrayList<Sach> lstS;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB(this);
        lv = findViewById(R.id.lvSach);
        lstS = new ArrayList<>();
        Sach s = new Sach(1,"De men phieu luu ky");
        db.addSach(s);
        Toast.makeText(this,"OK",Toast.LENGTH_LONG).show();
        LoadItem();
    }
    public void LoadItem(){
        db.getAllSach();
        customAdapter = new CustomAdapter(MainActivity.this,lstS);
        lv.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }
}

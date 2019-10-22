package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DB db;
    ListView lv;
    ArrayList<Sach> lstS;
    CustomAdapter customAdapter;
    Button btn;
    EditText tvId,tvTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB(this);
        lv = findViewById(R.id.lvSach);
        lstS = new ArrayList<>();
        Sach s = new Sach(1,"De men phieu luu ky");
        db.addSach(s);
        LoadItem();
        btn = findViewById(R.id.btnAdd);
        tvId = findViewById(R.id.etId);
        tvTen = findViewById(R.id.etName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sach newS = new Sach(Integer.parseInt(tvId.getText().toString()),tvTen.getText().toString());
                db.addSach(newS);
                customAdapter = new CustomAdapter(MainActivity.this,db.getAllSach());
                lv.setAdapter(customAdapter);
            }
        });
    }
    public void LoadItem(){
        customAdapter = new CustomAdapter(MainActivity.this,db.getAllSach());
        lv.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }
}

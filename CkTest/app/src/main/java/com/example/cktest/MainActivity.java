package com.example.cktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbContext data;
    ListView lv;

    EditText etMa, etTen;
    Button btnThem,btnXoa,btnSua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data= new DbContext(this);
        lv = findViewById(R.id.lv);
        ArrayAdapter<SinhVien> sinhVienArrayAdapte = new ArrayAdapter<SinhVien>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,data.getData());
        lv.setAdapter(sinhVienArrayAdapte);


        etMa = findViewById(R.id.etMs);
        etTen = findViewById(R.id.etTen);

        btnThem = findViewById(R.id.btnAdd);
        btnSua = findViewById(R.id.btnEdit);
        btnXoa = findViewById(R.id.btnRemove);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    data.addSach(new SinhVien(Integer.parseInt(etMa.getText().toString()),etTen.getText().toString()));
                    loadData();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"!!!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void loadData(){

        ArrayAdapter<SinhVien> sinhVienArrayAdapte = new ArrayAdapter<SinhVien>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,data.getData());
        lv.setAdapter(sinhVienArrayAdapte);
        sinhVienArrayAdapte.notifyDataSetChanged();

    }
}

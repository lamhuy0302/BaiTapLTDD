package com.example.student.bai1;

import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityBai5 extends AppCompatActivity {
    Button btnTinh,btnTiep,btnThongKe;
    EditText etTen,etSoLuongSach,etTongKhach,etTongVip,etTongTien;
    TextView tvThanhTien;
    CheckBox cbVip;
    ArrayList<KhachHang> ListKH;
    ArrayAdapter apt;
    public class KhachHang {
        String name;
        int Vip;
        int Tien;

        public KhachHang( String name, int Vip,int Tien) {
            this.name = name;
            this.Vip =Vip;
            this.Tien=Tien;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        etTen=(EditText)findViewById(R.id.etTen);
        btnTinh =(Button)findViewById(R.id.btnTinhTT);
        btnTiep = (Button)findViewById(R.id.btnTiepTuc);
        btnThongKe = (Button)findViewById(R.id.btnTK);
        cbVip = (CheckBox)findViewById(R.id.cbVip);
        etSoLuongSach = (EditText)findViewById(R.id.etSoLuongSach);
        tvThanhTien = (TextView)findViewById(R.id.tvTongTien);
        etTongKhach = (EditText)findViewById(R.id.etTongKH);
        ListKH = new ArrayList<KhachHang>();


        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(etSoLuongSach.getText().toString());
                if(cbVip.isChecked()==true)
                    tvThanhTien.setText(""+(sl*20000-(10/100*sl*20000)));
                else tvThanhTien.setText(""+(sl*20000));
            }
        });
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vip;
                    if(cbVip.isChecked()==true)
                        vip = 1;
                    else vip= 0;
                    ListKH.add(new KhachHang(etTen.getText().toString(),vip,Integer.parseInt(tvThanhTien.getText().toString())));
                    Toast.makeText(getApplicationContext(),"Thêm thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soVip = 0;
                etTongKhach.setText(""+ListKH.size());
                for(int row =1;row<=ListKH.size();row++){

                    if(ListKH.get(row).Vip ==1){
                        row++;
                    }
                    soVip++;
                }
                etTongVip.setText(""+soVip);
            }
        });

    }



}

package com.example.student.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityBai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
    }
    public void ChuyenNam(View v){
        int namDuong = Integer.parseInt(((EditText)findViewById(R.id.etNamDuong)).getText().toString());
        int can = namDuong%10;
        int chi = namDuong%12;
        String kq1="";
        String kq2="";
        if(can==0)
            kq1="Canh";
        else if(can==1)
            kq1="Tan";
        else if(can==2)
            kq1="Nham";
        else if(can==3)
            kq1="Quy";
        else if(can==4)
            kq1="Giap";
        else if(can==5)
            kq1="At";
        else if(can==6)
            kq1="Binh";
        else if(can==7)
            kq1="Dinh";
        else if(can==8)
            kq1="Mau";
        else if(can==9)
            kq1="Ky";


        if(chi==0)
            kq2="Than";
        else if(chi==1)
            kq2="Dau";
        else if(chi==2)
            kq2="Tuat";
        else if(chi==3)
            kq2="Hoi";
        else if(chi==4)
            kq2="Ty";
        else if(chi==5)
            kq2="Suu";
        else if(chi==6)
            kq2="Dan";
        else if(chi==7)
            kq2="Meo";
        else if(chi==8)
            kq2="Thin";
        else if(chi==9)
            kq2="Ty";
        else if(chi==10)
            kq2="Ngo";
        ((TextView)findViewById(R.id.tvNamAm)).setText(""+kq1+" "+kq2);
    }
}

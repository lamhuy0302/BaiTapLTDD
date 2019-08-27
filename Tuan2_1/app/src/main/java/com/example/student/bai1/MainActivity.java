package com.example.student.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Tong(View v){
        int a = Integer.parseInt(((EditText)findViewById(R.id.etA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.etB)).getText().toString());
        int sum = a+b;
        TextView kq = (TextView)findViewById(R.id.tvResult);
        kq.setText(""+ sum);
    }
    public void Hieu(View v){
        int a = Integer.parseInt(((EditText)findViewById(R.id.etA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.etB)).getText().toString());
        int sum = a-b;
        TextView kq = (TextView)findViewById(R.id.tvResult);
        kq.setText(""+ sum);
    }
    public void Tich(View v){
        int a = Integer.parseInt(((EditText)findViewById(R.id.etA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.etB)).getText().toString());
        int sum = a*b;
        TextView kq = (TextView)findViewById(R.id.tvResult);
        kq.setText(""+ sum);
    }
    public void Thuong(View v){
        int a = Integer.parseInt(((EditText)findViewById(R.id.etA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.etB)).getText().toString());
        int sum = a/b;
        TextView kq = (TextView)findViewById(R.id.tvResult);
        kq.setText(""+ sum);
    }
    public void Uoc(View v){
        int a = Integer.parseInt(((EditText)findViewById(R.id.etA)).getText().toString());
        int b = Integer.parseInt(((EditText)findViewById(R.id.etB)).getText().toString());
        int sum = a+b;
        TextView kq = (TextView)findViewById(R.id.tvResult);
        if (a == 0 || b == 0)
            kq.setText(""+ sum);;
        while (a != b)
        {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        kq.setText(""+a);
    }
    public void Thoat(View v){
       finish();
    }
}

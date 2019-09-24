package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnChange, btnA, btnB, btnAdd;
    EditText et;
    TextView tvA,tvB;
    FragmentManager fm;
    String txtA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChange = (Button)findViewById(R.id.btnchange);
        btnA = (Button)findViewById(R.id.btnA);
        btnB = (Button)findViewById(R.id.btnB);
        tvA = (TextView)findViewById(R.id.tvA);
        tvB = (TextView)findViewById(R.id.tvB);
        et = (EditText)findViewById(R.id.et);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        fm = getSupportFragmentManager();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_A A = (fragment_A) getSupportFragmentManager().findFragmentById(R.id.fragment);
                A.showText(et.getText().toString());
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_B A = (fragment_B) getSupportFragmentManager().findFragmentById(R.id.fragment2);
                A.showText(et.getText().toString());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.add(R.id.frame, new fragment_A());
                ft_add.commit();
            }
        });
    }
}

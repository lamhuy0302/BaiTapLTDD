package com.example.student.btintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnAva, btnCus, btnTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAva = findViewById(R.id.btnAvailable);
        btnCus = findViewById(R.id.btnCustom);
        btnTab = findViewById(R.id.btnTabbed);
        //--
        btnAva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoanCal.class);
                startActivity(intent);
            }
        });
        //--
        btnCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoanCal.class);
                intent.putExtras(LoanBundler.Random());
                startActivity(intent);
            }
        });
        //--

    }
}

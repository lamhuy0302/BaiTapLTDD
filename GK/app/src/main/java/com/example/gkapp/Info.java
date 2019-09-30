package com.example.gkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    ImageView ivPic;
    TextView tvTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        ivPic = findViewById(R.id.imPic);
        tvTen = findViewById(R.id.tvTen);

        Bundle intent = getIntent().getExtras();

        ivPic.setImageResource(intent.getInt("pic"));
        tvTen.setText(intent.getString("name"));
    }
}

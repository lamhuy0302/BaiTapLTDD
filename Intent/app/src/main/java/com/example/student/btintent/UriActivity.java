package com.example.student.btintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UriActivity extends Activity {

    Button btnCalUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        btnCalUri = findViewById(R.id.btnCalUri);
        btnCalUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adr = makeAdrFromET();
                Uri uri = Uri.parse(adr);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
    private String makeAdrFromET(){
        EditText loanIn = findViewById(R.id.etLoanAmount);
        Editable loan = loanIn.getText();
        String loanParam = String.format("loan=%s",loan);
        EditText rateIn = findViewById(R.id.etInterestRate);
        Editable rate = rateIn.getText();
        String rateParam = String.format("rate=%s",rate);
        EditText monthsIn = findViewById(R.id.etMonth);
        Editable months = monthsIn.getText();
        String monthsParam = String.format("months=%s",months);
        String baseAddress = "loan://coreservlets.com/calc";
        String address = String.format("%s?%s&%s&%s", baseAddress, loanParam, rateParam, monthsParam);
        return  address;
    }
}

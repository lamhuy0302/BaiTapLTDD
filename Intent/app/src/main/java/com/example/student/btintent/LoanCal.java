package com.example.student.btintent;

import android.content.Intent;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class LoanCal extends Activity {
    private double mloan = 100000.0, mrate = 5.0;
    private long mmonths = 360;
    //--
    TextView tvLoan, tvRate, tvMonths, tvMonthPay, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_available_input);
        setInputExtras();
        CalAndPrint();

    }

    //Available Input
    private void CalAndPrint() {
        PayInfo payInfo = new PayInfo(mloan, mrate, mmonths);
        tvLoan = findViewById(R.id.tvLoanAmount);
        tvLoan.setText(payInfo.getLoan());
        tvRate = findViewById(R.id.tvInterestRate);
        tvRate.setText(payInfo.getRate());
        tvMonths= findViewById(R.id.tvMonth);
        tvMonths.setText(payInfo.getMonths());
        tvMonthPay = findViewById(R.id.tvtMonthlyPay);
        tvMonthPay.setText(payInfo.getMonthPay());
        tvTotal = findViewById(R.id.tvTotal);
        tvTotal.setText(payInfo.getTotal());
    }
    //Cus Input
    private void setInputExtras(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            double loan = bundle.getDouble("loan");
            double rate = bundle.getDouble("rate");
            long months = bundle.getLong("months");
            setInputs(loan,rate,months);
        }
    }
    private void setInputs(double loan, double rate, long months){
        if (loan>0) mloan= loan;
        if (rate>0) mrate = rate;
        if(months>0) mmonths = months;
    }
}

package com.example.student.btintent;

import android.os.Bundle;

import java.util.Random;

public class LoanBundler {
    public static Bundle makeLoanInfo(double loan, double rate, long months){
        Bundle bundle = new Bundle();
        bundle.putDouble("loan",loan);
        bundle.putDouble("rate",rate);
        bundle.putDouble("months",months);
        return bundle;
    }
    public static Bundle Random(){
        Random random = new Random();
        double loan = 25000 * (1+random.nextInt(10));
        double rate = 0.25 * (1+random.nextInt(60));
        long months = 12 * (1+random.nextInt(30));
        return (LoanBundler.makeLoanInfo(loan,rate,months));
    }
}

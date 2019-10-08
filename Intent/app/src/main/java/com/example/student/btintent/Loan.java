package com.example.student.btintent;

public class Loan {
    public static double monthpay(double loan, double rate, long months){
        if(rate <= 0)
            rate = 0.0000001;
        double interestRate = rate/1200.0;
        double numb = loan * interestRate;
        double denominator = 1-Math.pow(1+interestRate,-1*months);
        return (numb/denominator);
    }
}

package com.example.student.btintent;

public class PayInfo {
    private  final double loan, rate, monthpay, totalpay;
    private  final long months;

    public String getLoan(){
        return Double.toString(loan);
    }
    public String getRate(){
        return Double.toString(rate);
    }
    public String getMonthPay(){
        return Double.toString(monthpay);
    }
    public String getTotal(){
        return Double.toString(totalpay);
    }
    public String getMonths(){
        return Long.toString(months);
    }

    public PayInfo(double loan, double rate, long months) {
        this.loan = loan;
        this.rate = rate;
        this.monthpay = Loan.monthpay(loan,rate,months);
        this.totalpay = monthpay*months;
        this.months = months;
    }
}

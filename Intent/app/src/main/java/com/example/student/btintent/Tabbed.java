package com.example.student.btintent;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TabHost;


public class Tabbed extends TabActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = getResources();
        TabHost host = getTabHost();
        //--Tab1
        Intent intent1 = new Intent(this, LoanCal.class);
        Bundle loanBundle1 = LoanBundler.makeLoanInfo(100000, 7.5, 120);
        intent1.putExtras(loanBundle1);
        TabHost.TabSpec tab1 = host.newTabSpec("1")
                .setIndicator("10 Year")
                .setContent(intent1);
        host.addTab(tab1);
        //--Tab2
        Uri y20 = Uri.parse("loan://coreservlets.com/calc");
        Intent intent2 = new Intent(Intent.ACTION_VIEW, y20);
        Bundle loanBundle2 = LoanBundler.makeLoanInfo(100000, 7.5, 240);
        intent2.putExtras(loanBundle2);
        TabHost.TabSpec tab2 = host.newTabSpec("2")
                .setIndicator("20 Year")
                .setContent(intent2);
        host.addTab(tab2);
        //--Tab3
        String baseAddress = "loan://coreservlets.com/calc";
        String address =
                String.format("%s?%s&%s&%s",
                        baseAddress,
                        "loanAmount=100000",
                        "annualInterestRateInPercent=7.5",
                        "loanPeriodInMonths=360");
        Uri y30 = Uri.parse(address);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, y30);
        TabHost.TabSpec tab3 = host.newTabSpec("3")
                .setIndicator("30 Year")
                .setContent(intent3);
        host.addTab(tab3);
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

            }
        });
    }
}

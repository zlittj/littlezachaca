package com.zachlittle.android.aca.daycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zachlittle.android.aca.daycounter.utils.DayCounter;

public class MainActivity extends AppCompatActivity {

    DayCounter mDayCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDayCounter = new DayCounter();

        for (int i = 1; i <= 12; i++) {
            int yearIn = 2016;
            System.out.println(i + "/" + yearIn + "has "
                    + mDayCounter.countDays(i, yearIn) + " days.");
            for (int d =1; d<= mDayCounter.countDays(i, yearIn); d++){
                System.out.println(i + "/" + d + "/" + yearIn);
            }
        }
    }
}


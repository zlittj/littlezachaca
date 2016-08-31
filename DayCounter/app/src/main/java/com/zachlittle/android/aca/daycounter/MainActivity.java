package com.zachlittle.android.aca.daycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <= 12; i++) {
            int yearIn = 2016;
            int monthIn = i;

            System.out.println(monthIn + "/" + yearIn + "has "
                    + countDays(monthIn, yearIn) + " days.");
            for (int d =1; d<=countDays(monthIn, yearIn); d++){
                System.out.println(monthIn + "/" + d + "/" + yearIn);
                            }
        }

    }


    private int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }

                if ((year % 100 == 0) && (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;

    }


}

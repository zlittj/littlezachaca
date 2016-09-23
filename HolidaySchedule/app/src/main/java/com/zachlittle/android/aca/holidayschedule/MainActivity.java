package com.zachlittle.android.aca.holidayschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;
    EditText mEditText;
    int inMonth;
    int inYear;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = mEditText.getText().toString();
                String m = Character.toString(info.charAt(0)) + Character.toString(info.charAt(1));
                String d = Character.toString(info.charAt(3)) + Character.toString(info.charAt(4));
                String y = Character.toString(info.charAt(6)) + Character.toString(info.charAt(7))
                         + Character.toString(info.charAt(8)) + Character.toString(info.charAt(9));
                inMonth = Integer.parseInt(m);
                inYear = Integer.parseInt(y);
                HolidaySchedule cal = new HolidaySchedule();
                DayCounter findDays = new DayCounter();


                if((inYear % 4) != 0) {
                    day = Integer.parseInt(d) + findDays.countDays(inMonth);
                }else {
                    if (findDays.countDays(inMonth) < 59) {
                        day = Integer.parseInt(d) + findDays.countDays(inMonth);
                    }else {
                        if ((inYear % 100 == 0) && (inYear % 400 != 0)) {
                            day = Integer.parseInt(d) + findDays.countDays(inMonth);
                        } else {
                            day = Integer.parseInt(d) + findDays.countDays(inMonth) +1;
                        }
                    }
                }

                if (day != 0) {
                    try {
                        int whichDay = Integer.parseInt(d);
                        if (cal.isHoliday(whichDay)) {
                            mTextView.append("\nDay number " + day + " is a holiday!");
                        } else {
                            mTextView.append("\nDay number " + day + " is not a holiday");
                        }
                    }catch (NumberFormatException nfe){
                        mTextView.append("\nError: " + nfe.getMessage());
                    }
                }

            }
        });



    }

    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {
            sked = new BitSet(366);
            int[] holiday = {1, 15, 50, 148, 185, 246, 281, 316, 326, 359};

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }

        public void addHoliday(int dayToAdd) {
            sked.set(dayToAdd);
        }

        public boolean isHoliday(int dayToCheck){
            return sked.get(dayToCheck);
        }
    }

    public class DayCounter {

        public int countDays(int month) {
            int count = -1;
            switch (month) {
                case 1:
                    count = 0;
                    break;
                case 2:
                    count = 31;
                    break;
                case 3:
                    count = 59;
                    break;
                case 4:
                    count = 90;
                    break;
                case 5:
                    count = 120;
                    break;
                case 6:
                    count = 151;
                    break;
                case 7:
                    count = 181;
                    break;
                case 8:
                    count = 212;
                    break;
                case 9:
                    count = 243;
                    break;
                case 10:
                    count = 273;
                    break;
                case 11:
                    count = 304;
                    break;
                case 12:
                    count = 334;

            }
            return count;
        }
    }
}

package com.zachlittle.android.aca.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mButton7;
    Button mButton8;
    Button mButton9;
    Button mButton0;

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton8 = (Button) findViewById(R.id.button8);
        mButton9 = (Button) findViewById(R.id.button9);
        mButton0 = (Button) findViewById(R.id.button0);

        mTextView = (TextView) findViewById(R.id.textView);

        final double buttonOne = 1;
        final double buttonTwo = 2;
        double buttonThree = 3;
        double buttonFour = 4;
        double buttonFive = 5;
        double buttonSix = 6;
        double buttonSeven = 7;
        double buttonEight = 8;
        double buttonNine = 9;
        double buttonZero = 0;



    mButton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mTextView.append(Double.toString(buttonOne));
        }
    });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Double.toString(buttonTwo));
            }
        });





    }
}

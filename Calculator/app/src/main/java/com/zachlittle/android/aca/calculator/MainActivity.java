package com.zachlittle.android.aca.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

//declaring my variables that will be used to calculate the operations
    double operandOne = 0.0d;
    double operandTwo = 0.0;
    char opp;


//declaring  member variables
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
    Button mButtonPeriod;
    Button mButtonNeg;

    Button mButtonBackspace;
    Button mButtonPlus;
    Button mButtonMinus;
    Button mButtonDivide;
    Button mButtonMultiply;
    Button mButtonEquals;
    Button mButtonC;
    Button mButtonAC;

    TextView mTextView;
    TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting my member variables to pull buttons and views from xml

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
        mButtonPeriod = (Button) findViewById(R.id.buttonPeriod);
        mButtonNeg = (Button) findViewById(R.id.buttonNeg);


        mButtonBackspace = (Button) findViewById(R.id.buttonBackspace);
        mButtonPlus = (Button) findViewById(R.id.buttonPlus);
        mButtonEquals = (Button) findViewById(R.id.buttonEquals);
        mButtonMinus = (Button) findViewById(R.id.buttonMinus);
        mButtonDivide = (Button) findViewById(R.id.buttonDivide);
        mButtonMultiply = (Button) findViewById(R.id.buttonMultiply);
        mButtonC = (Button) findViewById(R.id.buttonClear);
        mButtonAC = (Button)findViewById(R.id.buttonAllClear);

        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);

        //setting values for the buttons, these values won't change.

        final int buttonOne = 1;
        final int buttonTwo = 2;
        final int buttonThree = 3;
        final int buttonFour = 4;
        final int buttonFive = 5;
        final int buttonSix = 6;
        final int buttonSeven = 7;
        final int buttonEight = 8;
        final int buttonNine = 9;
        final int buttonZero = 0;
        final char buttonPeriod = '.';
        final char buttonNegative = '-';






//Next section is to take the buttons that you push and add them into the text field

    mButton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mTextView.append(Integer.toString(buttonOne));
        }
    });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonTwo));
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonThree));
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonFour));
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonFive));
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonSix));
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonSeven));
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonEight));
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonNine));
            }
        });

        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Integer.toString(buttonZero));
            }
        });

        mButtonPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.append(Character.toString(buttonPeriod));
            }
        });
        mButtonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String neg = "-" + mTextView.getText().toString();
                mTextView.setText(neg);
            }
        });







        //Setting up the operators to get the text from the first section add it to operandOne
        //Then clear the text field, set the opp variable and set the top text field to show what operation is taking place


        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTextView.getText().toString().length() == 0) {
                    mTextView.setText("");

                } else {

                    operandOne = Double.parseDouble(mTextView.getText().toString());
                    mTextView.setText("");
                    opp = '+';
                    String showCalc = Double.toString(operandOne) + " + ";
                    mTextView2.setText(showCalc);
                }

            }
        });
        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTextView.getText().toString().length() == 0) {
                    mTextView.setText("");

                }else {


                    operandOne = Double.parseDouble(mTextView.getText().toString());
                    mTextView.setText("");
                    opp = '-';
                    String showCalc = Double.toString(operandOne) + " - ";
                    mTextView2.setText(showCalc);
                }
            }
        });
        mButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTextView.getText().toString().length() == 0) {
                    mTextView.setText("");

                } else {
                    operandOne = Double.parseDouble(mTextView.getText().toString());
                    mTextView.setText("");
                    opp = '/';
                    String showCalc = Double.toString(operandOne) + " / ";
                    mTextView2.setText(showCalc);
                }
            }
        });
        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTextView.getText().toString().length() == 0) {
                    mTextView.setText("");

                } else {
                    operandOne = Double.parseDouble(mTextView.getText().toString());
                    mTextView.setText("");
                    opp = '*';
                    String showCalc = Double.toString(operandOne) + " * ";
                    mTextView2.setText(showCalc);
                }
            }
        });


        //Setup Clear Buttons

        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("");

            }
        });

        mButtonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("");
                operandOne = 0.0d;
                operandTwo = 1.0;
                opp = '\u0000';
                mTextView2.setText("");
            }
        });

        mButtonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTextView.getText().toString().length() == 0) {
                    mTextView.setText("");

                }else {
                    String backspace = mTextView.getText().toString();
                    mTextView.setText(backspace.substring(0, backspace.length() - 1));
                }
            }
        });








        //Setup the equals button to perform our calculations, if you hit equals then operandOne becomes operandTwo
        mButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opp == '+') {
                    operandTwo = Double.parseDouble(mTextView.getText().toString());
                    Double answer = operandOne + operandTwo;
                    String ans = Double.toString(answer);
                    String showCalc = Double.toString(operandOne) + " + " + Double.toString(operandTwo) + " =";
                    mTextView2.setText(showCalc);
                    mTextView.setText(ans);
                    operandOne = operandTwo;
                }
                if (opp == '-') {
                    operandTwo = Double.parseDouble(mTextView.getText().toString());
                    Double answer = operandOne - operandTwo;
                    String ans = Double.toString(answer);
                    String showCalc = Double.toString(operandOne) + " - " + Double.toString(operandTwo) + " =";
                    mTextView2.setText(showCalc);
                    mTextView.setText(ans);
                    operandOne = operandTwo;
                }
                if (opp == '/') {
                    operandTwo = Double.parseDouble(mTextView.getText().toString());
                    Double answer = operandOne / operandTwo;
                    String ans = Double.toString(answer);
                    String showCalc = Double.toString(operandOne) + " / " + Double.toString(operandTwo) + " =";
                    mTextView2.setText(showCalc);
                    mTextView.setText(ans);
                    operandOne = operandTwo;
                }
                if (opp == '*') {
                    operandTwo = Double.parseDouble(mTextView.getText().toString());
                    Double answer = operandOne * operandTwo;
                    String ans = Double.toString(answer);
                    String showCalc = Double.toString(operandOne) + " * " + Double.toString(operandTwo) + " =";
                    mTextView2.setText(showCalc);
                    mTextView.setText(ans);
                    operandOne = operandTwo;
                }
            }
        });




    }
}

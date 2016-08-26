package com.zachlittle.android.aca.temperatureconversion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView mOutputText;
    Button mConvertButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah =(TextView) findViewById(R.id.fahText);
        mCel =(TextView) findViewById(R.id.celText);
        mOutputText = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcButton);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String currentFah;
            String convertedTemp;
            String convertedFromCelTemp;
            String currentCel;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

            @Override
            public void onClick(View view) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (!mFah.getText().toString().equals("")) {


                    currentFah = mFah.getText().toString();
                    double fahValue = Integer.parseInt(currentFah);
                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;
                    convertedTemp = String.valueOf(fahValue);
                    String finishedTemp = convertedTemp + " C \n" + mFah.getText() + " F";

                    mOutputText.setText(finishedTemp);
                    mFah.setText("");


                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    double celValue = Integer.parseInt(currentCel);
                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;
                    convertedFromCelTemp = String.valueOf(celValue);
                    mOutputText.setText(mCel.getText() + " C\n" + convertedFromCelTemp + " F");
                    mCel.setText("");


                }




            }
        });




        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is...");
        // To convert F to C
        // begin by subtracting 32

        fah = fah - 32;
        // then we divide by
        fah = fah / 9;
        //then we multiply by 5
        fah = fah * 5;
        System.out.println(fah + "degrees Celsius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
        //to convert to celsius to fahrenheit
        //begin by multiplying by 9
        cel = cel * 9;
        //divide by 5
        cel = cel / 5;
        //add 32
        cel = cel + 32;
        System.out.println(cel + " degrees Fahrenheit\n");





    }
}

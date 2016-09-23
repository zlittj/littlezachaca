package com.zachlittle.android.aca.primefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PrimeFinder mPrimeFinder;
    Button mButton;
    TextView mTextView;
    EditText mNumInput;
    long longNum;
    String[] resultsArray;
    int numPrimes;
    int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mNumInput = (EditText) findViewById(R.id.editText);
        mTextView.setMovementMethod(new ScrollingMovementMethod());





        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("");
                longNum = Long.parseLong(mNumInput.getText().toString());
                int arraySize = (int) (longNum);
                resultsArray = new String[arraySize];
                mPrimeFinder = new PrimeFinder(longNum);
                while (mPrimeFinder.finished = true) {
                    for (int i =0; i < arraySize ; i++ ) {
                        mTextView.append(resultsArray[i]);
                        System.out.println(resultsArray[i]);

                    }
                }

            }
        });



    }




    public class PrimeFinder implements Runnable{


        public long target;
        public boolean finished = false;
        public Thread runner;




        PrimeFinder(long inTarget) {
            target = inTarget;

            if (runner == null){
                runner = new Thread(this);
                runner.start();
            }
        }
        @Override
        public void run() {
            long candidate = 2;
            numPrimes =0;
            while (candidate < target) {
                if (isPrime(candidate)) {
                    resultsArray[numPrimes] = ("Here's a prime!:" + candidate);
                    numPrimes++;

                }
                candidate++;

            }
            finished = true;

        }

        boolean isPrime(long checkNumber) {
            double root = Math.sqrt(checkNumber);
            for (int i =2; i<=root; i++) {
                if (checkNumber % i ==0) {
                    return false;
                }
            }return true;
        }



    }
}
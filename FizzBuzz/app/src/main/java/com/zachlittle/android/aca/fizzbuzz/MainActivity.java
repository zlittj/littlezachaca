package com.zachlittle.android.aca.fizzbuzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mNumInput;
    TextView mTextView;
    Button mButton;
    String integerFromText;
    int n;
    int t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumInput = (EditText) findViewById(R.id.numInput);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        mButton = (Button) findViewById(R.id.button);



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTextView.setText("");
                n=0;
                integerFromText = mNumInput.getText().toString();
                n = Integer.parseInt(integerFromText);

                int[] numberArray;
                numberArray = new int[n];
                int z = n - 1;
                t = n;

                do {
                    numberArray[t-1] = t;
                    t--;
                }while (t !=0);

                int i =z;
                do  {
                    int y = numberArray[(n-i)-1];

                    if ((n-i) % 3 == 0 && (n-i) % 5 != 0) {
                        mTextView.append("Fizz \n");
                    }

                    if ((n-i) % 5 == 0 && (n-i) % 3 != 0) {
                        mTextView.append("Buzz \n");
                    }

                    if ((n-i) % 5 == 0 && (n-i) % 3 == 0) {
                        mTextView.append("FizzBuzz \n");
                    }

                    if ((n-i) % 5 != 0 && (n-i) % 3 != 0) {
                        mTextView.append(y + "\n");
                    }

                    i--;

                }while ((i+1) != 0);
            }
        });






    }
}

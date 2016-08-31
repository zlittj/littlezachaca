package com.zachlittle.android.aca.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;
    EditText mEditText;
    int myNumber;
    //one two three four five six seven eight nine ten

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
                String wordFormNumber = mEditText.getText().toString();
                char firstChar = wordFormNumber.charAt(0);
                char secondChar = wordFormNumber.charAt(1);



                switch (firstChar) {
                    case 'o':
                        myNumber =1;
                        break;
                    case 't':
                        switch (secondChar) {
                            case 'w':
                                myNumber = 2;
                                break;
                            case 'h':
                                myNumber = 3;
                                break;
                            case 'e':
                                myNumber =10;
                                break;
                            default:
                                break;

                        }
                    case 'f':
                        switch (secondChar) {
                            case 'o':
                                myNumber = 4;
                                break;
                            case 'i':
                                myNumber = 5;
                                break;
                        }
                    case 's':
                        switch (secondChar) {
                            case 'i':
                                myNumber = 6;
                                break;
                            case 'e':
                                myNumber = 7;
                                break;
                        }
                    case 'e':
                        myNumber =8;
                        break;
                    case 'n':
                        myNumber =9;
                        break;
                    default:
                        myNumber =11;
                        break;
                }

                if (myNumber !=11) {
                    mTextView.setText("Your number is: " + myNumber);
                }else { mTextView.setText("You didn't type it in right!");}

            }
        });




    }
}

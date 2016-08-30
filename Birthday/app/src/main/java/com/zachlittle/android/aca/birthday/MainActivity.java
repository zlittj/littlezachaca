package com.zachlittle.android.aca.birthday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);


        String birthday;
        //setup a string called birthday
        birthday = "04/29/2014";



        //create substrings of string birthday
       String month = birthday.substring(0, 2);
        String day = birthday.substring(3, 5);
        String year = birthday.substring(6, 10);
        //display the substrings
        mTextView.append(month + "/" + day + "/" + year);


        //create new cake object with varibles now set.
        Cake birthDayCake = new Cake(12, 3, 5);


        //display via append the cake's dimensions
        mTextView.append("\n height: " + birthDayCake.height
            + "\n weight: " + birthDayCake.weight
            + "\n depth: " + birthDayCake.depth
        );








    }
    //create a cake object class and a constructor
    public class Cake {
        int height;
        int weight;
        int depth;

        Cake(int he, int we, int de) {
           height = he;
           weight = we;
           depth = de;


        }
    }
}

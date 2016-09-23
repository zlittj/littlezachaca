package com.zachlittle.android.aca.marsrobot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  TextView mScreenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreenTextView = (TextView) findViewById(R.id.main_text_view);
        mScreenTextView.setMovementMethod(new ScrollingMovementMethod());




        MarsRobot spirit = new MarsRobot(this);
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;





        mScreenTextView.append("\nMars Robot Spirit has landed");
        spirit.showAttributes();
        mScreenTextView.append("\nIncreasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        mScreenTextView.append("\nChanging temperature to -90");
        spirit.temperature = -90;
        spirit.showAttributes();
        mScreenTextView.append("\nChecking the temperature.");
        spirit.checkTemperature();
        spirit.showAttributes();
        spirit.isItSafe();




        MarsRobot fire = new MarsRobot(this);
        fire.status = "Trying to find Samples;";
        fire.speed = 0;
        fire.temperature = -60;
        fire.sampleType = "none";
        fire.areSamplesLoaded = false;
        fire.sampleWeight = 0;

        mScreenTextView.append("\nMars Robot Fire Has Landed!");
        fire.showAttributes();
        fire.showNewAttributes();
        mScreenTextView.append("\nAttempting to get a new sample....");
        fire.sampleType = "dirt";
        fire.getSample();
        mScreenTextView.append("\nNow lets adjust the speed and try to find some rocks!");
        fire.speed = 5;
        fire.showAttributes();
        mScreenTextView.append("\nLets stop here and check for rocks!");
        fire.speed = 0;
        fire.sampleType = "Rocks";
        fire.getSample();


    }
}

package com.zachlittle.android.aca.marsrobot;

import android.content.Context;
import android.widget.TextView;
/**
 * Created by Zach on 8/24/16.
 */




public class MarsRobot {
    Context context;
     MarsRobot(Context context) {
        this.context=context;
    }
        String status;
        int speed;
        float temperature;
        int sampleWeight;
        String sampleType;
        boolean areSamplesLoaded;


    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;

        }
    }
    public void showAttributes() {
        TextView mScreenTextView = (TextView) ((MainActivity) context).findViewById(R.id.main_text_view);
        mScreenTextView.append("\nStatus: " + status);
        mScreenTextView.append("\nSpeed: " + speed);
        mScreenTextView.append("\nTemperature: " + temperature);
    }
    public void showNewAttributes() {
        TextView mScreenTextView = (TextView) ((MainActivity) context).findViewById(R.id.main_text_view);
        mScreenTextView.append("\nSample Weight: " + sampleWeight);
        mScreenTextView.append("\nSample Type: " + sampleType);
        mScreenTextView.append("\nIs the Sample Loaded?: " + areSamplesLoaded);
    }


    public void getSample() {
        TextView mScreenTextView = (TextView) ((MainActivity) context).findViewById(R.id.main_text_view);
        if (sampleType != "Rocks") {
            areSamplesLoaded = false;
            mScreenTextView.append("\nNo Rocks!");
        }
        if (sampleType == "Rocks") {
            areSamplesLoaded = true;
            sampleWeight = 3;
            mScreenTextView.append("\nYasssss dere da rocks!");
        }
    }

     public void isItSafe() {
         TextView mScreenTextView = (TextView) ((MainActivity) context).findViewById(R.id.main_text_view);
        if ((temperature > -80) ^ (temperature < 400) ) {
            mScreenTextView.append("\nThe operating temp is safe");

     }
    }

}



package com.zachlittle.android.aca.eightball;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ArrayList<String> mAnswersTopArrayList = new ArrayList<>(20);
    ArrayList<String> mAnswersMiddleArrayList = new ArrayList<>(20);
    ArrayList<String> mAnswersBottomArrayList = new ArrayList<>(20);
    TextView mTextViewTop;
    TextView mTextViewMiddle;
    TextView mTextViewBottom;
    TextView mTextViewDiceResult;
    private final static float ACC = 30;
    ImageView mImageView1;
    ImageView mImageView2;
    ImageButton mImageButton;
    long mTimeKeeper = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create my text views ready for use
        mTextViewTop = (TextView) findViewById(R.id.textView);
        mTextViewMiddle = (TextView) findViewById(R.id.textViewMiddle);
        mTextViewBottom = (TextView) findViewById(R.id.textViewBottom);
        mTextViewDiceResult = (TextView) findViewById(R.id.textViewDiceResult);

        //get my image views ready(they are invisible by default)
        mImageView1 = (ImageView) findViewById(R.id.imageView1);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);

        //setup my image button so that it will make the image views disapear
        mImageButton = (ImageButton) findViewById(R.id.imageButton6);

        //create my sensor manager so that shaking it works
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        //This is my string arrays with the standard 20 questions.I split it up into three to show it on three lines
        String[] addTheTop = {
                "It", "It", "Without", "Yes,", "You may", "As I see", "Most", "Outlook", "", "Signs point", "Reply hazy",
                "Ask again", "Better not", "Cannot predict", "Concentrate", "Don't", "My reply", "My sources", "Outlook not", "Very"
        };
        String[] addTheMiddle ={
                "is certain", "is decidedly", "a doubt", "definitely", "rely on", "it, yes", "likely", "good", "Yes",
                "to yes", "try again", "later", "tell you", "now", "and ask", "count on", "is no", "say no", "so good", "doubtful"
        };
        String[] addTheBottom ={
                "", "so","", "","it", "","", "","", "","", "","now", "","again", "it","", "","", "",
        };

        //this puts my strings array into three array lists
        mAnswersTopArrayList.addAll(Arrays.asList(addTheTop));
        mAnswersMiddleArrayList.addAll(Arrays.asList(addTheMiddle));
        mAnswersBottomArrayList.addAll(Arrays.asList(addTheBottom));


        //Create my array for images
        final int[] idLists = {
                R.drawable.asset_one, R.drawable.asset_two, R.drawable.asset_three,
                R.drawable.asset_four, R.drawable.asset_five, R.drawable.asset_six
        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random numGenOne = new Random();
                //num generators
                final int randomNumberOne = numGenOne.nextInt(5);
                final int randomNumberTwo = numGenOne.nextInt(5);
                //set the image to visible and random
                mImageView1.setImageResource(idLists[randomNumberOne]);
                mImageView2.setImageResource(idLists[randomNumberTwo]);
                mImageView1.setVisibility(View.VISIBLE);
                mImageView2.setVisibility(View.VISIBLE);
                String s = String.valueOf((randomNumberOne + randomNumberTwo+2));
                mTextViewDiceResult.setText(s);
                mTextViewDiceResult.setVisibility(View.VISIBLE);
                //set the background image to invisible as well as text views
                mImageButton.setVisibility(View.INVISIBLE);
                mTextViewTop.setVisibility(View.INVISIBLE);
                mTextViewMiddle.setVisibility(View.INVISIBLE);
                mTextViewBottom.setVisibility(View.INVISIBLE);
            }
        });//end of the onclick listner for the floating action button

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabStop);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView1.setVisibility(View.INVISIBLE);
                mImageView2.setVisibility(View.INVISIBLE);
                mTextViewDiceResult.setVisibility(View.INVISIBLE);
                mImageButton.setVisibility(View.VISIBLE);
                mTextViewTop.setVisibility(View.VISIBLE);
                mTextViewBottom.setVisibility(View.VISIBLE);
                mTextViewMiddle.setVisibility(View.VISIBLE);
            }
        });




    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] shaker = event.values;
        long times = event.timestamp;
        if ((Math.abs(shaker[0]) > ACC || Math.abs(shaker[1]) > ACC || Math
                .abs(shaker[2]) > ACC) && (times>(mTimeKeeper+20000))) {
            Random randNumGen = new Random();
            int randomNumber = randNumGen.nextInt(20);
            mTextViewTop.setText(mAnswersTopArrayList.get(randomNumber));
            mTextViewMiddle.setText(mAnswersMiddleArrayList.get(randomNumber));
            mTextViewBottom.setText(mAnswersBottomArrayList.get(randomNumber));
            mTimeKeeper= times;
        }
    }// end of onsensorchanged

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}//end of mainactivity

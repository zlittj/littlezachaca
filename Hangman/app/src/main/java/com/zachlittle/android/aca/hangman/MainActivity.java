package com.zachlittle.android.aca.hangman;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String mStringFromRandom;
    Words mWords = new Words();
    LinearLayout mRelativeLayout;
    ImageView[] mImageViews = new ImageView[6];
    TextView mTextViewCharsBad;
    public char[] getChars() {
        return mChars;
    }

    public void setChars(char[] chars) {
        mChars = chars;
    }

    char[] mChars = new char[20];
    TextView[] myTextView = new TextView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTextViewCharsBad = (TextView) findViewById(R.id.textViewCharsBad);
        mImageViews[0] = (ImageView) findViewById(R.id.imageViewHead);
        mImageViews[1] = (ImageView) findViewById(R.id.imageViewBody);
        mImageViews[2] = (ImageView) findViewById(R.id.imageViewLeftArm);
        mImageViews[3] = (ImageView) findViewById(R.id.imageViewRightArm);
        mImageViews[4] = (ImageView) findViewById(R.id.imageViewLeftLeg);
        mImageViews[5] = (ImageView) findViewById(R.id.imageViewRightLeg);
            for (int q=0; q<6; q++){
                mImageViews[q].setVisibility(View.INVISIBLE);
            }
        mRelativeLayout = (LinearLayout) findViewById(R.id.linLayout);

        mStringFromRandom = mWords.getWordToHangYou();
        Log.i("looky a stirng", mStringFromRandom);
        for (int j = 0; j < (mStringFromRandom.length()); j++) {
            mChars[j] = mStringFromRandom.charAt(j);
        }

        for (int i = 0; i < (mStringFromRandom.length()); i++) {
            TextView rowTextView = new TextView(this);
            mRelativeLayout.addView(rowTextView);
            myTextView[i] = rowTextView;
            String s = Character.toString(mChars[i]) + " ";
            rowTextView.setAllCaps(true);
            rowTextView.setBackgroundColor(getResources().getColor(R.color.black));
            rowTextView.setTextSize(20f);
            rowTextView.setText(s);
        }





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inflater to enter in a char
                DialogEnterText dialog = new DialogEnterText();
                dialog.show(getFragmentManager(), "");
                //in here i will want to check if mchar contains the letter, if so then set the background to white, else print the text in a new linear text field
                //also show image of the guy dieing
            }
        });
    }


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





}// end of class

package com.zachlittle.android.aca.classchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button mButtonFinished;
    Button mButtonHelp;
    Button mButtonRepeat;
    TextView mTextNameDisplay;
    ProgressBar mProgressBar;
    private static final String SERVER_URL = "https://class-checker.firebaseio.com/";
    private DatabaseReference mDataBase;
    String mName = "zach_little";
    private static final String HELP = "_help";
    private static final String ANYONE_REPEAT = "anyone_repeat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonFinished = (Button) findViewById(R.id.buttonFinished);
        mButtonHelp = (Button) findViewById(R.id.buttonHelp);
        mButtonRepeat =(Button) findViewById(R.id.buttonRepeat);
        mTextNameDisplay = (TextView) findViewById(R.id.textView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


        mButtonFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send some info over the interwebs to say you're done
                mDataBase = FirebaseDatabase.getInstance().getReference();
                mDataBase.child(mName).setValue(true);
            }
        });

        mButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send info on the interwebs that notifies prof that this person needs help
                mDataBase = FirebaseDatabase.getInstance().getReference();
                mDataBase.child(mName + HELP).setValue(true);
            }
        });

        mButtonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send info on the weberroots that lets teach know I need that last thing to be repeated
                mDataBase = FirebaseDatabase.getInstance().getReference();
                mDataBase.child(ANYONE_REPEAT).setValue(true);
            }
        });
        //Use a get text from the menu to insert the name of the user in here
        mTextNameDisplay.setText(mName);

        //create a progress bar that fills up as people respond. this will require a get http request, it may be worth leaving
        //blank for now and adding it in later if i want it
        mProgressBar.setVisibility(View.INVISIBLE);

    }
}

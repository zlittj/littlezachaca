package com.zachlittle.android.aca.classchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageButton mButtonFinished;
    ImageButton mButtonHelp;
    ImageButton mButtonRepeat;
    TextView mTextNameDisplay;
    ProgressBar mProgressBar;

    private DatabaseReference mDataBase;
    Name mNewName;
    private static final String HELP = "_help";
    private static final String ANYONE_REPEAT = "anyone_repeat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonFinished = (ImageButton) findViewById(R.id.imageButtonFinished);
        mButtonHelp = (ImageButton) findViewById(R.id.imageButtonHelp);
        mButtonRepeat =(ImageButton) findViewById(R.id.imageButtonRepeat);
        mTextNameDisplay = (TextView) findViewById(R.id.textView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


        mButtonFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send some info over the interwebs to say you're done
                mDataBase = FirebaseDatabase.getInstance().getReference();
                mDataBase.child(mNewName.getName()).setValue(true);
            }
        });

        mButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send info on the interwebs that notifies prof that this person needs help
                mDataBase = FirebaseDatabase.getInstance().getReference();
                mDataBase.child(mNewName.getName() + HELP).setValue(true);
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


        //create a progress bar that fills up as people respond. this will require a get http request, it may be worth leaving
        //blank for now and adding it in later if i want it
        mProgressBar.setVisibility(View.INVISIBLE);

    }//end of oncreate

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
            //name entry from menuname java class
            MenuNameEntry nameEntry = new MenuNameEntry();
            nameEntry.show(getFragmentManager(), "");
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    public void createNewName(Name n){
        mNewName = n;
    }



}

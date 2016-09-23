package com.zachlittle.android.aca.classchecker;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProfActivity extends AppCompatActivity{
    private DatabaseReference mDatabase;
    /* for now I'm going to get rid of the progress bar and add it in later, for now I'll add in the functions i need with an arraylist
    ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    */
    public String helpName;
    ImageButton mImageButtonProf;
    String[] names = {
            "Andrew", "Carson","Chandler", "Chris", "DanielA", "DanielB", "Diane", "Gabe", "Jackson", "Karen", "Micheal", "Robin", "Teresa", "Zidan", "zach_little"
    };
    boolean[] nameValues = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_activity);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
        mImageButtonProf = (ImageButton) findViewById(R.id.imageButtonProf);
       // mProgressBar.setProgress(mProgressStatus);
        //mProgressBar.setMax(15);
        final ArrayList<String> keeper = new ArrayList<>(0);



        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i("onChildChanged", dataSnapshot.getKey());
                Log.i("onChildChanged", dataSnapshot.getValue().toString());
                String key = dataSnapshot.getKey();
                String value = dataSnapshot.getValue().toString();

                   if (key.equals("anyone_repeat") && value.equals("true")) {
                       Log.i("tagger", "setting anyone");
                       //alert David to repeat himself
                       AlertRepeatDialog myDialog = new AlertRepeatDialog();
                       myDialog.show(getFragmentManager(), "");
                       //reset the value of repeat
                       mDatabase.child("anyone_repeat").setValue("false");
                   }

                for (int i=0; i<names.length; i++){
                    if (key.equals(names[i]) && value.equals("true")){
                        nameValues[i] = true;
                        System.out.println(nameValues[i] + names[i]);
                        //this next code adds values to my progress bar
                       // mProgressBar.incrementProgressBy(1);
                        keeper.add(names[i]);
                        //this next code pops up a screen to notify david that all are done
                        if (keeper.size() == 15){
                            //pop up something here
                            keeper.clear();
                            AlertFinishedDialog myDialog = new AlertFinishedDialog();
                            myDialog.show(getFragmentManager(), "");
                        }
                    }//end of if loop
                    if (key.equals(names[i]+ "_help") && value.equals("true")){
                        Log.i("onChildChanged", names[i]);
                        AlertHelpDialog myDialog = new AlertHelpDialog();
                        myDialog.setHelpName(names[i]);
                        myDialog.show(getFragmentManager(), "");
                    }
                }//end of for loop for value changes

                //check if anyone has p ushed the help button


            }//end of onchild changed

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });//end of child event listner

        mImageButtonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (String name : names) {
                    mDatabase.child(name).setValue(false);
                    mDatabase.child(name + "_help").setValue(false);
                }
                for (int i = 0; i<nameValues.length; i++){ nameValues[i] = false;}
                mDatabase.child("anyone_repeat").setValue(false);
            }
        });


    }
    public String getHelpName(){
        return helpName;
    }
}

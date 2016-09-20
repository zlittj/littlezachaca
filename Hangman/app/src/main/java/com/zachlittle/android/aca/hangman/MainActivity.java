package com.zachlittle.android.aca.hangman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButtonA;
    Button mButtonB;
    Button mButtonC;
    Button mButtonD;
    Button mButtonE;
    Button mButtonF;
    Button mButtonG;
    Button mButtonH;
    Button mButtonI;
    Button mButtonJ;
    Button mButtonK;
    Button mButtonL;
    Button mButtonM;
    Button mButtonN;
    Button mButtonO;
    Button mButtonP;
    Button mButtonQ;
    Button mButtonR;
    Button mButtonS;
    Button mButtonT;
    Button mButtonU;
    Button mButtonV;
    Button mButtonW;
    Button mButtonX;
    Button mButtonY;
    Button mButtonZ;

    String mStringFromRandom;
    Words mWords = new Words();
    LinearLayout mLinearLayout;
    ImageView[] mImageViews = new ImageView[6];

    boolean b;
    char mChar;
    int mInt = 0;
    int mIntTwo =0;
    char[] mChars = new char[20];
    TextView[] myTextView = new TextView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mButtonA = (Button) findViewById(R.id.buttonA);
        mButtonB = (Button) findViewById(R.id.buttonB);
        mButtonC = (Button) findViewById(R.id.buttonC);
        mButtonD = (Button) findViewById(R.id.buttonD);
        mButtonE = (Button) findViewById(R.id.buttonE);
        mButtonF = (Button) findViewById(R.id.buttonF);
        mButtonG = (Button) findViewById(R.id.buttonG);
        mButtonH = (Button) findViewById(R.id.buttonH);
        mButtonI = (Button) findViewById(R.id.buttonI);
        mButtonJ = (Button) findViewById(R.id.buttonJ);
        mButtonK = (Button) findViewById(R.id.buttonK);
        mButtonL = (Button) findViewById(R.id.buttonL);
        mButtonM = (Button) findViewById(R.id.buttonM);
        mButtonN = (Button) findViewById(R.id.buttonN);
        mButtonO = (Button) findViewById(R.id.buttonO);
        mButtonP = (Button) findViewById(R.id.buttonP);
        mButtonQ = (Button) findViewById(R.id.buttonQ);
        mButtonR = (Button) findViewById(R.id.buttonR);
        mButtonS = (Button) findViewById(R.id.buttonS);
        mButtonT = (Button) findViewById(R.id.buttonT);
        mButtonU = (Button) findViewById(R.id.buttonU);
        mButtonV = (Button) findViewById(R.id.buttonV);
        mButtonW = (Button) findViewById(R.id.buttonW);
        mButtonX = (Button) findViewById(R.id.buttonX);
        mButtonY = (Button) findViewById(R.id.buttonY);
        mButtonZ = (Button) findViewById(R.id.buttonZ);

        mImageViews[0] = (ImageView) findViewById(R.id.imageViewHead);
        mImageViews[1] = (ImageView) findViewById(R.id.imageViewBody);
        mImageViews[2] = (ImageView) findViewById(R.id.imageViewLeftArm);
        mImageViews[3] = (ImageView) findViewById(R.id.imageViewRightArm);
        mImageViews[4] = (ImageView) findViewById(R.id.imageViewLeftLeg);
        mImageViews[5] = (ImageView) findViewById(R.id.imageViewRightLeg);
            for (int q=0; q<6; q++){
                mImageViews[q].setVisibility(View.INVISIBLE);
            }
        mLinearLayout = (LinearLayout) findViewById(R.id.linLayout);


        mStringFromRandom = mWords.getWordToHangYou();
        Log.i("looky a string", mStringFromRandom);
        for (int j = 0; j < (mStringFromRandom.length()); j++) {
            mChars[j] = mStringFromRandom.charAt(j);
        }

        for (int i = 0; i < (mStringFromRandom.length()); i++) {
            TextView rowTextView = new TextView(this);
            mLinearLayout.addView(rowTextView);
            myTextView[i] = rowTextView;
            rowTextView.setAllCaps(true);
            rowTextView.setTextSize(20f);
            rowTextView.setText("___"+ "  ");
        }
    }//end of on Create

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

    public void myClickChecker(View display){
        int id = display.getId();
        b = false;

        switch (id){
            case R.id.buttonA:
                mButtonA.setVisibility(View.GONE);
                mChar = 'a';
                break;
            case R.id.buttonB:
                mButtonB.setVisibility(View.GONE);
                mChar = 'b';
                break;
            case R.id.buttonC:
                mButtonC.setVisibility(View.GONE);
                mChar = 'c';
                break;
            case R.id.buttonD:
                mButtonD.setVisibility(View.GONE);
                mChar = 'd';
                break;
            case R.id.buttonE:
                mButtonE.setVisibility(View.GONE);
                mChar = 'e';
                break;
            case R.id.buttonF:
                mButtonF.setVisibility(View.GONE);
                mChar = 'f';
                break;
            case R.id.buttonG:
                mButtonG.setVisibility(View.GONE);
                mChar = 'g';
                break;
            case R.id.buttonH:
                mButtonH.setVisibility(View.GONE);
                mChar = 'h';
                break;
            case R.id.buttonI:
                mButtonI.setVisibility(View.GONE);
                mChar = 'i';
                break;
            case R.id.buttonJ:
                mButtonJ.setVisibility(View.GONE);
                mChar = 'j';
                break;
            case R.id.buttonK:
                mButtonK.setVisibility(View.GONE);
                mChar = 'k';
                break;
            case R.id.buttonL:
                mButtonL.setVisibility(View.GONE);
                mChar = 'l';
                break;
            case R.id.buttonM:
                mButtonM.setVisibility(View.GONE);
                mChar = 'm';
                break;
            case R.id.buttonN:
                mButtonN.setVisibility(View.GONE);
                mChar = 'n';
                break;
            case R.id.buttonO:
                mButtonO.setVisibility(View.GONE);
                mChar = 'o';
                break;
            case R.id.buttonP:
                mButtonP.setVisibility(View.GONE);
                mChar = 'p';
                break;
            case R.id.buttonQ:
                mButtonQ.setVisibility(View.GONE);
                mChar = 'q';
                break;
            case R.id.buttonR:
                mButtonR.setVisibility(View.GONE);
                mChar = 'r';
                break;
            case R.id.buttonS:
                mButtonS.setVisibility(View.GONE);
                mChar = 's';
                break;
            case R.id.buttonT:
                mButtonT.setVisibility(View.GONE);
                mChar = 't';
                break;
            case R.id.buttonU:
                mButtonU.setVisibility(View.GONE);
                mChar = 'u';
                break;
            case R.id.buttonV:
                mButtonV.setVisibility(View.GONE);
                mChar = 'v';
                break;
            case R.id.buttonW:
                mButtonW.setVisibility(View.GONE);
                mChar = 'w';
                break;
            case R.id.buttonX:
                mButtonX.setVisibility(View.GONE);
                mChar = 'x';
                break;
            case R.id.buttonY:
                mButtonY.setVisibility(View.GONE);
                mChar = 'y';
                break;
            case R.id.buttonZ:
                mButtonZ.setVisibility(View.GONE);
                mChar = 'z';
                break;

        }//end of switch
        for (int i=0; i<mChars.length; i++) {
            if (mChars[i] == mChar) {
                Log.i("good", "its a good one      " +mChar);
                String s = Character.toString(mChars[i]) + "   ";
                myTextView[i].setText(s);
                mIntTwo++;
                Log.i("int", "   " + mIntTwo);
                Log.i("mchars length", "   " + mStringFromRandom.length());
                b = true;
                if (mStringFromRandom.length() == mIntTwo){
                    Log.i("boolean", "" + b);
                    isB();
                }
            }
        }

        if (b) {
            //do nothing
        }else {
            Log.i("bad", ""+mChar);
            mImageViews[mInt].setVisibility(View.VISIBLE);
            mInt++;
            if (mInt == 6){
                isB();
            }
        }
    }

    public void isB() {
        DialogEnterText dialogEnterText = new DialogEnterText();
        Bundle bundle = new Bundle();
        bundle.putBoolean("TAG", b);
        dialogEnterText.setArguments(bundle);
        dialogEnterText.show(getFragmentManager(), "");
    }

}// end of class

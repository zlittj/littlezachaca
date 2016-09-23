package com.zachlittle.android.aca.hangman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

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

    Animation mAnimLeftRight;
    Animation mAnimRightLeft;
    Animation mAnimTopBottom;
    Animation mAnimFadeIn;
    Animation mOnLose;

    String mStringFromRandom;
    Words mWords = new Words();
    LinearLayout mLinearLayout;
    ImageView[] mImageViews = new ImageView[6];
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    boolean mB;
    char mChar;
    int mInt = 0;
    int mIntTwo =0;
    char[] mChars = new char[20];
    TextView[] mTextView = new TextView[20];
    int mScore;
    boolean mIfHighScore = false;
    int mHighScore;
    Animation mAnimation;
    int mTotalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadAnimations();
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
        int sizeOfArray = mWords.getLength();
        Log.i("size", "here is the zied"+sizeOfArray);
        for (int j = 0; j < (mStringFromRandom.length()); j++) {
            mChars[j] = mStringFromRandom.charAt(j);
        }

        for (int i = 0; i < (mStringFromRandom.length()); i++) {
            TextView rowTextView = new TextView(this);
            mLinearLayout.addView(rowTextView);
            mTextView[i] = rowTextView;
            rowTextView.setAllCaps(true);
            rowTextView.setTextSize(20f);
            String blanks = "__  ";
            rowTextView.setText(blanks);
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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void myClickChecker(View display){
        int id = display.getId();
        mB = false;

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
                mTextView[i].setText(s);
                mIntTwo++;
                mScore = mScore +10;
                Log.i("int", "   " + mIntTwo);
                Log.i("mchars length", "   " + mStringFromRandom.length());
                mB = true;
                if (mStringFromRandom.length() == mIntTwo){
                    Log.i("boolean", "" + mB);
                    mScore = mScore*mStringFromRandom.length();
                    isB();
                }
            }
        }

        if (!mB) {
            Log.i("bad", ""+mChar);
            randomAnim(mInt);
            mImageViews[mInt].setVisibility(View.VISIBLE);

            mInt++;
            mScore = mScore -2;
            if (mInt == 6){
                mScore = mScore + mStringFromRandom.length();
                losingAnim();
            }
        }
    }

    public void isB() {
        mSharedPreferences = getSharedPreferences("Hangman", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mHighScore = mSharedPreferences.getInt("SCORE", 0);
        mTotalScore = mScore + mSharedPreferences.getInt("TOTALSCORE", 0);
        mEditor.putInt("TOTALSCORE", mTotalScore);
        if (mHighScore < mScore){
            mEditor.putInt("SCORE", mScore);
            mEditor.commit();
            mIfHighScore = true;
        }

        DialogEnterText dialogEnterText = new DialogEnterText();
        Bundle bundle = new Bundle();
        bundle.putInt("TSCORE", mTotalScore);
        bundle.putBoolean("TAG", mB);
        bundle.putString("WORD", mStringFromRandom);
        bundle.putBoolean("IFHIGHSCORE", mIfHighScore);
        bundle.putInt("HIGHSCORE", mHighScore);
        bundle.putInt("SCORE", mScore);
        dialogEnterText.setArguments(bundle);
        dialogEnterText.show(getFragmentManager(), "");
    }
    private void loadAnimations(){
        mAnimLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
        mAnimRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
        mAnimTopBottom = AnimationUtils.loadAnimation(this,R.anim.top_bot);
        mAnimFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mOnLose = AnimationUtils.loadAnimation(this, R.anim.on_lose);
    }
    private void losingAnim(){
        mOnLose.setDuration(3000);
        for (int i=0; i<mImageViews.length; i++){
            mImageViews[i].startAnimation(mOnLose);
        }
        mOnLose.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("inAnim", "Animating"+animation);
                if (animation == mOnLose){
                    isB();
                }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
    private void randomAnim(int i){
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(3);
        Animation[] anims = {mAnimTopBottom, mAnimRightLeft, mAnimFadeIn, mAnimLeftRight};
        mAnimation = anims[randomNum];
        mAnimation.setDuration(1000);
        mImageViews[i].startAnimation(mAnimation);
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("cancel", "cancel anim");
                animation.cancel();
                animation.reset();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {}

    @Override
    public void onAnimationRepeat(Animation animation) {}
}// end of class

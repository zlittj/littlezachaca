package com.zachlittle.android.aca.hangman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DialogEnterText extends DialogFragment {

    private char mChar;
    boolean mBoolean;
    TextView textView;
    TextView mTextViewDisplayWord;
    TextView mTextViewScore;
    int mHighScore;
    boolean mIfHighScore;
    int mTotalScore;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.char_enter, null);
        Button btnEnter = (Button) dialogView.findViewById(R.id.button);
        textView = (TextView) dialogView.findViewById(R.id.textView);
        mTextViewDisplayWord = (TextView) dialogView.findViewById(R.id.textViewDisplayWord);
        mTextViewScore = (TextView) dialogView.findViewById(R.id.textViewScore);



        Bundle bundle = this.getArguments();
        mIfHighScore = bundle.getBoolean("IFHIGHSCORE");
        mBoolean = bundle.getBoolean("TAG", false);
        mHighScore = bundle.getInt("HIGHSCORE");
        mTotalScore = bundle.getInt("TSCORE");
        Log.i("dialog boo", ""+mBoolean);
        if (mBoolean){
            textView.setText(R.string.winner);
        }else {
            textView.setText(R.string.loser);
        }
        String addToView = "\n\n"+ "The word was: " +bundle.getString("WORD");
        mTextViewDisplayWord.setText(addToView);
        addToView = "Your Score: " +bundle.getInt("SCORE");
        mTextViewScore.setText(addToView);
        if (mIfHighScore){
            mTextViewScore.append("\n\n\nITS A NEW HIGH SCORE!!!!!");
            mTextViewScore.append("\n Your Total Score: " + mTotalScore);
        }else {
            mTextViewScore.append("\n \n\nYour High Score: " + mHighScore);
            mTextViewScore.append("\n Your Total Score: " + mTotalScore);
        }

        builder.setView(dialogView);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).recreate();
                dismiss();
            }
        });
        return builder.create();
    }

}

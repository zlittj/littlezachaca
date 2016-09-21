package com.zachlittle.android.aca.hangman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
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
    SharedPreferences mSharedPreferences;

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
        mBoolean = bundle.getBoolean("TAG", false);
        Log.i("dialog boo", ""+mBoolean);
        if (mBoolean){
            textView.setText(R.string.winner);
        }else {
            textView.setText(R.string.loser);
        }
        String addToView = "\n\n"+ "The word was: " +bundle.getString("WORD");
        mTextViewDisplayWord.setText(addToView);
        addToView = "Your Score: " +bundle.getInt("SCORE");
        if (bundle.getBoolean("HIGHSCORE")){
            mTextViewScore.append("ITS A NEW HIGH SCORE!!!!!");
        }
        mTextViewScore.setText(addToView);

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

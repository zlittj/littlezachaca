package com.zachlittle.android.aca.hangman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DialogEnterText extends DialogFragment {

    private char mChar;
    int changingForTheGood =0;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.char_enter, null);
        final EditText editChar = (EditText) dialogView.findViewById(R.id.editText);
        Button btnEnter = (Button) dialogView.findViewById(R.id.button);
        final MainActivity mainActivity = new MainActivity();
        final char[] newChar  = mainActivity.getChars();


        builder.setView(dialogView);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChar = editChar.getText().charAt(0);
                for (int i=0; i<newChar.length; i++){
                    if(mChar == newChar[i]){
                        Log.i("inIF", "checking");
                        //reveal that it is one of the chosen ones
                        mainActivity.myTextView[i].setBackgroundColor(getResources().getColor(R.color.white));
                    }//else {
                        //hang something
//                        mainActivity.mImageViews[changingForTheGood].setVisibility(View.VISIBLE);
//                        changingForTheGood++;
                        //put the text into a box
//                        mainActivity.mTextViewCharsBad.append(mChar + "  ");

                }




                dismiss();
            }
        });
        return builder.create();
    }

    public char getChar(){
        return mChar;
    }
}

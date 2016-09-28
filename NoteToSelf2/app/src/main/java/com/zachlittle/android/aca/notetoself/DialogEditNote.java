package com.zachlittle.android.aca.notetoself;


import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class DialogEditNote extends DialogFragment {

    private Note mNote;
    private ImageView mImageView;
    private String mPicFilename;
    private Bitmap mRaw;
    private int mInt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View dialogView = inflater.inflate(R.layout.dialog_edit_note, container, false);

        final EditText editTitle = (EditText) dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText) dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = (CheckBox) dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = (CheckBox) dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = (CheckBox) dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);
        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);
        Button btnCapture = (Button) dialogView.findViewById(R.id.btnCapture);
        mImageView = (ImageView) dialogView.findViewById(R.id.imageView);

        editTitle.setText(mNote.getTitle());
        editDescription.setText(mNote.getDescription());
        checkBoxIdea.setChecked(mNote.isIdea());
        checkBoxImportant.setChecked(mNote.isImportant());
        checkBoxTodo.setChecked(mNote.isTodo());
        mPicFilename = mNote.getPicFilename();
        if (mNote.getPicFilename() != null){
            mRaw = BitmapFactory.decodeFile(mNote.getPicFilename());
            try {
                mImageView.setImageBitmap(mRaw);
            }catch (Exception e){
                Log.e("tag", "error", e);
            }
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new note
                Note newNote = new Note();

                //Set it's variables to match the users entries on the form
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());
                if (mPicFilename != null){newNote.setPicFilename(mPicFilename);}
                else {newNote.setPicFilename("good");}

                //Get a reference to Main Activity
                MainActivity callingActivity = (MainActivity) getActivity();

                //Pass newNote back to MainActivity
                callingActivity.replaceNewNote(mInt, newNote);


                //Quit the dialog
                dismiss();
            }
        });

        return dialogView;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImageView.getDrawable() !=null) {
            BitmapDrawable bd = (BitmapDrawable) mImageView.getDrawable();
            bd.getBitmap().recycle();
            mImageView.setImageBitmap(null);
        }

    }

    public void sendNote(Note n){
        mNote = n;
    }
    public void sendWhichItem(int i){
        mInt = i;
    }


}

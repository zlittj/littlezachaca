package com.zachlittle.android.aca.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;


public class DialogShowNote extends DialogFragment {

    private Note mNote;
    private Bitmap mRaw;
    private ImageView mIvPicInNote;
    private int mInt;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescription);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        ImageView ivImportant = (ImageView) dialogView.findViewById(R.id.imageViewImportant);
        ImageView ivTodo = (ImageView) dialogView.findViewById(R.id.imageViewTodo);
        ImageView ivIdea = (ImageView) dialogView.findViewById(R.id.imageViewIdea);
        mIvPicInNote = (ImageView) dialogView.findViewById(R.id.imageViewPicInNote);

        ImageButton shareButton = (ImageButton) dialogView.findViewById(R.id.imageButtonShare);
        Switch editSwitch = (Switch) dialogView.findViewById(R.id.switchEdit);

        if (!mNote.isImportant()){
            ivImportant.setVisibility(View.GONE);
        }
        if (!mNote.isTodo()){
            ivTodo.setVisibility(View.GONE);
        }
        if (!mNote.isIdea()){
            ivIdea.setVisibility(View.GONE);
        }
        if (mNote.getPicFilename() != null){
            mRaw = BitmapFactory.decodeFile(mNote.getPicFilename());
           try {
               mIvPicInNote.setImageBitmap(mRaw);
           }catch (Exception e){
               Log.e("tag", "error", e);
           }
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView).setTitle("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        editSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    FragmentManager fragmentManager = getFragmentManager();
                    DialogEditNote note = new DialogEditNote();
                    note.sendNote(mNote);
                    note.sendWhichItem(mInt);
                    fragmentManager.beginTransaction()
                            .add(note, "")
                            .commit();

                    isChecked = false;
                    dismiss();
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream byter = new ByteArrayOutputStream();
                mRaw.compress(Bitmap.CompressFormat.JPEG, 100, byter);
                String path = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), mRaw, "Title", null);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_TEXT, (mNote.getTitle()+"\n" +mNote.getDescription()));
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
                startActivity(Intent.createChooser(intent, "Share Note"));
            }
        });

        return builder.create();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mIvPicInNote.getDrawable() !=null) {
            BitmapDrawable bd = (BitmapDrawable) mIvPicInNote.getDrawable();
            bd.getBitmap().recycle();
            mIvPicInNote.setImageBitmap(null);
        }
    }

    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }
    public void sendWhichItem(int i){
        mInt = i;
    }
}
package com.zachlittle.android.aca.classchecker;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuNameEntry extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.name_entry, null);
        final EditText editName = (EditText) dialogView.findViewById(R.id.editTextName);
        Button btnCancel = (Button) dialogView.findViewById(R.id.buttonCancel);
        Button btnOK = (Button) dialogView.findViewById(R.id.buttonOK);

        builder.setView(dialogView).setMessage("Enter Your Name");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name name = new Name();
                name.setName(editName.getText().toString());

                //Get a reference to Main Activity
                MainActivity callingActivity = (MainActivity) getActivity();
                //pass name back to MainActivity
                callingActivity.createNewName(name);
                if (name.getName().equals("david_jones")){
                    Intent intent = new Intent(callingActivity, ProfActivity.class);
                    startActivity(intent);
                }
                callingActivity.mTextNameDisplay.setText(name.getName());
                dismiss();
            }
        });
        return builder.create();
    }//end of dialog
}

package com.zachlittle.android.aca.classchecker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;


public class AlertHelpDialog extends DialogFragment {

    Name mHelpMeName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class because this dialog has a simple UI
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Dialog will have "Make a selection" as the title
        builder.setMessage("Help!!!!!!!!!!!!" + mHelpMeName.getName())
                // An OK button that does nothing
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Nothing happening here

                    }
                });

        // Create the object and return it
        return builder.create();

    }// End onCreateDialog
}

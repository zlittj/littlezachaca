package com.zachlittle.android.aca.filmsearch;


import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchDialogFragment extends DialogFragment {

    private EditText mEditTextSearch;
    private Button mButtonSearch;
    private Button mButtonCancel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_search, container, false);

        mEditTextSearch = (EditText) view.findViewById(R.id.enterSearch);
        mButtonSearch = (Button) view.findViewById(R.id.buttonSearch);
        mButtonCancel = (Button) view.findViewById(R.id.buttonCancel);

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = new MainFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragHolder, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("search", mEditTextSearch.getText().toString());
                Fragment fragment = new MainFragment();
                fragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragHolder, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

        return view;
    }
}

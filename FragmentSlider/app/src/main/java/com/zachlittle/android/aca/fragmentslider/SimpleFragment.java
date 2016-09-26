package com.zachlittle.android.aca.fragmentslider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment{

    public static final String MESSAGE = "";

    public static SimpleFragment newInstance(String message){
        SimpleFragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(MESSAGE, message);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String message = getArguments().getString(MESSAGE);
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        TextView messageTextView = (TextView) view.findViewById(R.id.textView);

        messageTextView.setText(message);

        return view;
    }
}

package com.zachlittle.android.aca.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class FragmentA extends Fragment {

    private EventBus mBus = EventBus.getDefault();
    private TextView mUserStatus;

    //required empty constructor
    public FragmentA() {
        //nothing here
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_, container, false);

        mUserStatus = (TextView) rootView.findViewById(R.id.user_status);


        return rootView;
    }

    /**
     * Reciving Lognin event when it happens
     */

    @Subscribe
    public void onLoginEvent(LoginEvent event){
        mUserStatus.setText("User Status: Logged in, userName: " + event.mUserName);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBus.register(this); //register the bus
    }

    @Override
    public void onStop() {
        mBus.unregister(this); //unregister the event bus
        super.onStop();
    }























}

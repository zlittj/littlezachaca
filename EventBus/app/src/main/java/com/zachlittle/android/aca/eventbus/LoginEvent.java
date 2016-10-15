package com.zachlittle.android.aca.eventbus;


public class LoginEvent {

    public final String mUserName;

    public LoginEvent(String username){
        this.mUserName = username;
    }

}

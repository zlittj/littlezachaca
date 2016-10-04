package com.zachlittle.android.aca.wheresitssnap;


import android.location.Location;
import android.net.Uri;

public class Photo {

    private String mTitle;
    private Uri mStorageLocation;
    private Location mGpsLocation;
    private String mTag1;
    private String mTag2;
    private String mTag3;


    public String getTag3() {
        return mTag3;
    }

    public Location getGpsLocation() {
        return mGpsLocation;
    }

    public void setGpsLocation(Location gpsLocation) {
        mGpsLocation = gpsLocation;
    }

    public void setTag3(String tag3) {
        mTag3 = tag3;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Uri getStorageLocation() {
        return mStorageLocation;
    }

    public void setStorageLocation(Uri storageLocation) {
        mStorageLocation = storageLocation;
    }

    public String getTag1() {
        return mTag1;
    }

    public void setTag1(String tag1) {
        mTag1 = tag1;
    }

    public String getTag2() {
        return mTag2;
    }

    public void setTag2(String tag2) {
        mTag2 = tag2;
    }
}

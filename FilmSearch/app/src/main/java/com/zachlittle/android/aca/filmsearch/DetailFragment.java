package com.zachlittle.android.aca.filmsearch;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment{

    private TextView mTextViewTitle;
    private TextView mTextViewDescription;
    private ImageView mImageViewBackground;
    private ImageView mImageViewPoster;

    private String mTitle;
    private String mDescription;
    private String mBackdrop;
    private String mPoster;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        mTextViewTitle = (TextView) view.findViewById(R.id.titleView);
        mTextViewDescription = (TextView) view.findViewById(R.id.description);
        mImageViewBackground = (ImageView) view.findViewById(R.id.backgroundView);
        mImageViewPoster = (ImageView) view.findViewById(R.id.poster);

        Bundle bundle = getArguments();
        Log.i("tag", ""+bundle.getString("movie_title"));
        mTitle = bundle.getString("movie_title");
        mDescription = bundle.getString("movie_description");
        mBackdrop = bundle.getString("movie_backdrop");
        mPoster = bundle.getString("movie_poster");

        Picasso.with(getActivity()).load(mPoster).into(mImageViewPoster);
        Picasso.with(getActivity()).load(mBackdrop).into(mImageViewBackground);
        mTextViewTitle.setText(mTitle);
        mTextViewDescription.setText(mDescription);



        return view;
    }
}

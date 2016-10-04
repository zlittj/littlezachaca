package com.zachlittle.android.aca.wheresitssnap;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ViewFragment extends Fragment{

    private Cursor mCursor;
    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = getArguments().getInt("Position");

        // Load the appropriate photo from db
        DataManager d = new DataManager(getActivity().getApplicationContext());
        mCursor = d.getPhoto(position);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        TextView textView  = (TextView) view.findViewById(R.id.textView);
        Button buttonShowLocation = (Button) view.findViewById(R.id.buttonShowLocation);

        // Set the text from the tile column of the data.
        textView.setText(mCursor.getString(mCursor.getColumnIndex(DataManager.TABLE_ROW_TITLE)));

        mImageView = (ImageView) view.findViewById(R.id.imageView);

        // Load the image into the TextView via the URI
        mImageView.setImageURI(Uri.parse(mCursor.getString(mCursor.getColumnIndex(DataManager.TABLE_ROW_URI))));

        buttonShowLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double latitude = Double.valueOf(mCursor.getString(mCursor.getColumnIndex(DataManager.TABLE_ROW_LOCATION_LAT)));
                double longitude = Double.valueOf(mCursor.getString(mCursor.getColumnIndex(DataManager.TABLE_ROW_LOCATION_LONG)));
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);

                // Create a Google maps intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

                // Start the maps activity
                getActivity().startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BitmapDrawable bd = (BitmapDrawable) mImageView.getDrawable();
        bd.getBitmap().recycle();
        mImageView.setImageBitmap(null);
    }
}

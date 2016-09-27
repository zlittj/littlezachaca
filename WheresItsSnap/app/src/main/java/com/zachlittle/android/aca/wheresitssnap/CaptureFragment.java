package com.zachlittle.android.aca.wheresitssnap;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CaptureFragment extends Fragment {

    private static final int CAMERA_REQUEST = 123;
    private ImageView mImageView;

    String mCurrentPhotoPath;

    private Uri mImageUri = Uri.EMPTY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.capture_fragment, container, false);

        mImageView = (ImageView) view.findViewById(R.id.imageView);
        Button  btnCapture = (Button) view.findViewById(R.id.btnCapture);
        Button btnSave = (Button) view.findViewById(R.id.btnSave);

        final EditText mEditTextTitle = (EditText) view.findViewById(R.id.editTextTitle);
        final EditText mEditTextTag1 = (EditText) view.findViewById(R.id.editTextTag1);
        final EditText mEdditTetTag2 = (EditText) view.findViewById(R.id.editTextTag2);
        final EditText mEditTextTag3 = (EditText) view.findViewById(R.id.editTextTag3);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile = null;
                try {
                    photoFile = createImageFile();
                }catch (IOException ex){
                    Log.e("error", "error creating file");
                }
                if (photoFile !=null){
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        return view;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  // filename
                ".jpg",         // extension
                storageDir      // folder
        );

        // Save for use with ACTION_VIEW Intent
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            try {
                mImageView.setImageURI(Uri.parse(mImageUri.toString()));
            }catch (Exception e){
                Log.e("Error", "Uri not set");
            }
        }else {
            mImageUri = Uri.EMPTY;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BitmapDrawable bd = (BitmapDrawable) mImageView.getDrawable();
        bd.getBitmap().recycle();
        mImageView.setImageBitmap(null);
    }
}

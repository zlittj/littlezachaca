package com.example.zachb.appsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity{

    Button backButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        backButton = (Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick();
            }
        });

        Intent intent = getIntent();
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ArrayList<String> message = intent.getStringArrayListExtra(MainActivity.RESULTS_MESSAGE);
        for(int i=0; i<message.size(); i++){
            mTextView.append("\n");
            mTextView.append(Html.fromHtml("<a href=" + message.get(i) + ">" + message.get(i) + "/a>"));
            mTextView.append("\n\n");
            i++;
            mTextView.append(message.get(i));
            mTextView.append("\n\n\n\n\n");
        }
    }

    public void onBackClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

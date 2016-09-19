package com.example.zachb.appsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zachb.appsearch.models.RelatedTopic;
import com.example.zachb.appsearch.models.User;

import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity{

    Button backButton;
    ArrayList<String> message = new ArrayList<>();
    private LinksAdapter mLinksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        ListView listView = (ListView) findViewById(R.id.listView);
        mLinksAdapter = new LinksAdapter();
        listView.setAdapter(mLinksAdapter);
        backButton = (Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick();
            }
        });



        

        //about to do some formating so that i can populate a ListView
        /*
        for(int i=0; i<message.size(); i++){
            mTextView.append("\n");
            mTextView.append(Html.fromHtml("<a href=" + message.get(i) + ">" + message.get(i) + "/a>"));
            mTextView.append("\n\n");
            i++;
            mTextView.append(message.get(i));
            mTextView.append("\n\n\n\n\n");
        }*/
    }

    public void onBackClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }// end of my oncreate

    public class LinksAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            User tempUser = new User();
            RelatedTopic tempTopics = new RelatedTopic();
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listlink, parent, false);
            }//end of if

            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);

            // Add the text to the heading and description
            txtTitle.setText(tempTopics.getFirstURL());
            txtDescription.setText(tempTopics.getText());

            return view;
        }//end of getView
    }// end of LinksAdapter
















}

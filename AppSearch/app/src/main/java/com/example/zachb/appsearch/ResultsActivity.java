package com.example.zachb.appsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import java.util.List;


public class ResultsActivity extends AppCompatActivity{

    Button backButton;
    ArrayList<String> message = new ArrayList<>();
    private LinksAdapter mLinksAdapter;
    User tempUser = new User();
    RelatedTopic tempTopics = new RelatedTopic();
    List<RelatedTopic> tempList = new ArrayList<>();
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        ListView listView = (ListView) findViewById(R.id.listView);
        mLinksAdapter = new LinksAdapter();

        tempList = tempUser.getRelatedTopics();
        for(int i=0; i<2; i++){
            Log.i("tag", "infor floop");
            mLinksAdapter.addToView(tempList.get(i));
        }
        listView.setAdapter(mLinksAdapter);

        backButton = (Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick();
            }
        });

    }

    public void onBackClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }// end of my oncreate

    public class LinksAdapter extends BaseAdapter {
        List<RelatedTopic> tempList = new ArrayList<>();
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
            Log.i("In Results", "insidegetView");

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listlink, parent, false);
            }//end of if

            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);

            // Add the text to the heading and description


            tempTopics = tempList.get(position);
            txtTitle.setText(tempTopics.getFirstURL());



            return view;
        }//end of getView
        public void addToView(RelatedTopic relate){
            tempList.add(relate);
            notifyDataSetChanged();
        }

    }// end of LinksAdapter
















}

package com.example.zachb.appsearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditText;
    TextView mResultsView;
    final String API_INITIAL = "https://api.duckduckgo.com/q=";
    final String API_FINAL = "&format=json";
    String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultsView = (TextView) findViewById(R.id.resultsView);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText = mEditText.getText().toString();
                new RetrieveFeedTask().execute();
            }
        });



    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        String searchText = mEditText.getText().toString();
        protected void onPreExecute() {
            mResultsView.setText("");

        }

        protected String doInBackground(Void... urls) {


            try{
                URL url = new URL(API_INITIAL + searchText + API_FINAL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally {
                    urlConnection.disconnect();
                }
            }
            catch (Exception e) {
                Log.e("Error", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
            Log.i("INFO", response);
            mResultsView.setText(response);

            //try {
           //     JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
            //    String Heading = object.getString("Heading");
             //   String Abstract = object.getString("Abstract");
             //   String Result = object.getString("Results");
            //    mResultsView.append(Heading + Abstract + Result);
         //   } catch (JSONException e){
           //     e.printStackTrace();
           // }
        }
    }



}

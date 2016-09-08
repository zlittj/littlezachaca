package com.example.zachb.appsearch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zachb.appsearch.models.RelatedTopic;
import com.example.zachb.appsearch.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditText;
    TextView mResultsView;
    final String API_INITIAL = "https://api.duckduckgo.com/?q=";
    final String API_FINAL = "&format=json";
    String searchText;
    String apiComplete;
    final String TAG = "API Info";
    RelatedTopic mRelatedTopic;
    User mUser;
    ArrayList<String> listData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultsView = (TextView) findViewById(R.id.resultsView);
        mResultsView.setMovementMethod(new ScrollingMovementMethod());
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText = mEditText.getText().toString();
                apiComplete = (API_INITIAL + searchText + API_FINAL);
                if (isNetworkAvailible()) {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(apiComplete)
                            .build();

                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try {
                                String jsonData = response.body().string();
                                Log.v(TAG, jsonData);
                                if (response.isSuccessful()) {
                                    mUser = getUserHeading(jsonData);
                                } else {
                                    alertUserAboutError();
                                }
                            } catch (IOException e) {
                                Log.e(TAG, "Exception caught: ", e);
                            } catch (JSONException e) {
                                Log.e(TAG, "Exception caught: ", e);
                            }
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        for (int j =0; j<listData.size(); j++) {
                                            mResultsView.append("\n" + listData.get(j));

                                        }
                                    }catch (Exception e) {
                                        Log.e(TAG, "Exception caught", e);
                                    }
                                }
                            });

                        }
                    });
                }
            }
        });

    }

    private User getUserHeading(String jsonData) throws JSONException{
        JSONObject resultsObject = new JSONObject(jsonData);

        User newUser = new User();
        newUser.setHeading(resultsObject.getString("Heading"));
        newUser.setAbstractURL(resultsObject.getString("AbstractURL"));

        JSONArray jArray = (JSONArray) resultsObject.get("RelatedTopics");


        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                String test = jArray.getString(i);
                listData.add(test);
            }
        }
        Log.i(TAG, "From JSON" + newUser);
        return newUser;
    }

    private RelatedTopic getInfo(String listData) throws JSONException {
        JSONArray infoObject = new JSONArray(listData);
        RelatedTopic newTopic = new RelatedTopic();
        for (int m = 0; m<listData.length(); m++) {
        }
        return null;
    }

    private boolean isNetworkAvailible() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        boolean isAvailible = false;
        if(info != null && info.isConnected()) {
            isAvailible = true;
        }return isAvailible;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }
}
package com.example.zachb.appsearch;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    final String API_INITIAL = "https://api.duckduckgo.com/?q=";
    final String API_FINAL = "&format=json&pretty=1";
    public static final String TAG_RELATED_TOPICS ="RelatedTopics";
    public static final String RESULTS_MESSAGE = "com.example.zachb.appsearch.RESULTS";;
    String searchText;
    String apiComplete;
    final String TAG = "API Info";
    User mUser;
    public ArrayList<String> toOtherView = new ArrayList<>();
    User newUser = new User();
    TextView newTextView;
    char replaceSpace = ' ';
    char newPlus = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText = mEditText.getText().toString();
                if (searchText.contains(" ")){ searchText = searchText.replace(replaceSpace, newPlus );}
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
                        public void onResponse(Call call, final Response response) throws IOException {
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
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }

    private User getUserHeading(String jsonData) throws JSONException{
        JSONObject resultsObject = new JSONObject(jsonData);
        JSONArray jArray = resultsObject.getJSONArray(TAG_RELATED_TOPICS);
            for (int i = 0; i <3; i++) {
                JSONObject test = jArray.getJSONObject(i);
                //String jsonResultString = test.getString("Result");
                //String jsonIconString = test.getString("Icon");
                String jsonFirstURLString = test.getString("FirstURL");
                String jsonTextString = test.getString("Text");
                //Log.d("TestingURL: ",  jsonResultString);
                //toOtherView.add(jsonResultString);
                //toOtherView.add(jsonIconString);
                toOtherView.add(jsonFirstURLString);
                toOtherView.add(jsonTextString);
            }
        goToResults();
        return newUser;
    }

    public void goToResults() {
        newTextView = (TextView) findViewById(R.id.textView);
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putStringArrayListExtra(RESULTS_MESSAGE, toOtherView);
        startActivity(intent);

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
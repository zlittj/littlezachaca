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
import java.util.List;

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
    public static final String TAG_HEADING = "Heading";
    public static final String TAG_ABSTRACT_URL ="abstractURL";
    public static final String TAG_RELATED_TOPICS ="RelatedTopics";
    String searchText;
    String apiComplete;
    final String TAG = "API Info";
    RelatedTopic mRelatedTopic;
    User mUser;
    List<String> listData = new ArrayList<>();
    //JSONArray listData = new JSONArray();
    User newUser = new User();
    RelatedTopic relatedTopic = new RelatedTopic();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultsView = (TextView) findViewById(R.id.textView);
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
                                Log.e(TAG, "Exception caught: ", e);
                            }
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        for (int j =0; j<listData.size(); j++) {
                                            mResultsView.append("\n\n\n\n\n\n\n" + listData.get(j));
                                            //mResultsView.append("\n\n\n\n" + new);
                                           // mResultsView.append(newUser.getHeading());
                                        }
                                        Log.d(TAG, listData.toString());
                                        //User test = new User();
                                        //mResultsView.append("\n" + listData.toString());
                                        //mResultsView.append("\n" + test.getRelatedTopics());
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

        newUser.setHeading(resultsObject.getString(TAG_HEADING));
       // newUser.setAbstractURL(resultsObject.getString(TAG_ABSTRACT_URL));
        JSONArray jArray = resultsObject.getJSONArray(TAG_RELATED_TOPICS);


        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                String testString;
                //Log.d("TestingCrap", testString);
                JSONObject test = jArray.getJSONObject(i);
                String obArray = test.getString("Result");
                //test = obArray.getJSONObject(i);
                testString = test.getString("FirstURL");
                Log.d("TestingURL: ",  obArray);
                listData.add(obArray);
                /*for(int y = 0; y<test.length(); y++) {
                    JSONObject obTwo = obArray.getJSONObject(y);
                    String test2 = obTwo.toString();
                    listData.add(i, test2);
                }
                */
            }
        }
        Log.i(TAG, "From JSON" + newUser);
        return newUser;
    }

    /*private RelatedTopic getInfo(String listData) throws JSONException {
        JSONArray infoObject = new JSONArray(listData);
        RelatedTopic newTopic = new RelatedTopic();
        for (int m = 0; m<listData.length(); m++) {
        }
        return null;
    }*/

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
package com.zachlittle.android.aca.duckducksearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zachlittle.android.aca.duckducksearch.Models.DuckDuck;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity{

    EditText mEditText;
    Button mButton;
    public String getSearchInput;
    public static final String API_INITIAL = "https://api.duckduckgo.com/?q=";
    public static final String API_FINAL = "&format=json";
    public String finalUrl;
    public static final String TAG = "JSON DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSearchInput = mEditText.getText().toString();   // I have a bug that will mess me up if there is more than one word
                finalUrl = (API_INITIAL + getSearchInput + API_FINAL); // fix bug with a + instead of space
                //System.out.println(finalUrl);
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(finalUrl)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                String relatedTopics = "users";
                DuckDuckGoApi duckDuckService = retrofit.create(DuckDuckGoApi.class);
                Call<DuckDuck> results = duckDuckService.getUser(relatedTopics);
                Log.v(TAG, duckDuckService.toString());
                results.enqueue(new Callback<DuckDuck>() {
                    @Override
                    public void onResponse(Call<DuckDuck> call, Response<DuckDuck> response){
                       // Log.v(TAG, response.body().toString());
                        DuckDuck duckDuck = response.body();
                        Log.d(TAG, duckDuck.getAbstractURL());
                    }

                    @Override
                    public void onFailure(Call<DuckDuck> call, Throwable t) {

                    }
                });





            }
        });


    }


    public interface DuckDuckGoApi {
        @GET("DuckDuck/{heading}")
        Call<DuckDuck> getHeading(@Path("heading") String heading);

        @GET("users/{username}")
        Call<DuckDuck> getUser(@Path("username") String username);

    }
}

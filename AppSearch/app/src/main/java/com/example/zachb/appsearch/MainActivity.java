package com.example.zachb.appsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zachb.appsearch.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditText;
    TextView mResultsView;
    final String API_INITIAL = "https://api.duckduckgo.com/q=";
    final String API_FINAL = "&format=json/";
    String searchText;
    String apiComplete = (API_INITIAL + searchText + API_FINAL);



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

               MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);

                apiService.getResult(c)


               /* MyApiEndpointInterface apiService =
                        retrofit.create(MyApiEndpointInterface.class);
                String result = "url";
                Call<User> call = apiService.getResult(result);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        User user = response.body();
                        System.out.println(user.toString());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });*/


               // new RetrieveFeedTask().execute();
            }
        });



    }


    Gson gson = new GsonBuilder()
            .setDateFormat("yyy-MM-dd'T'HH:mm:ssZ")
            .create();



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(apiComplete)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public interface MyApiEndpointInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @GET("RelatedTopics/Text:")
        void getResult(@Query("result") String result);

        @GET("group/{id}/users")
        Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

        @POST("users/new")
        Call<User> createUser(@Body User user);
    }

   /* class RelatedTopics {
        String result;
        String icon;
        String text;

        public String getResult() {
            return result;
        }
        public String getIcon() {
            return icon;
        }
        public String getText() {
            return text;
        }
    }

    public class DuckDuckGoResponses {
        ArrayList<RelatedTopics> topics;

        public DuckDuckGoResponses() {
            topics = new ArrayList<>();
        }



    }
    public static DuckDuckGoResponses parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        DuckDuckGoResponses duckDuckGoResponses = gson.fromJson(response, DuckDuckGoResponses.class);
        return duckDuckGoResponses;
    }*/



   /* class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

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

            RelatedTopics relatedTopics = gson.fromJson(response, RelatedTopics.class);
            String test = relatedTopics.toString();
            mResultsView.append(test); */


           // mResultsView.setText(response);

           /* try {
                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
                String RelatedTopics = object.getString("RelatedTopics");
                String Abstract = object.getString("Abstract");
                String Result = object.getString("Results");

            } catch (JSONException e){
                e.printStackTrace();
            }
           */




       // }
   // }



}

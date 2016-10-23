package com.zachlittle.android.aca.filmsearch;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MoviesAdapter mAdapter;
    List<Movie> mMovies = new ArrayList<>();
    private String mSearch;
    Call<Movie.MovieResult> mCall;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new MoviesAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        Bundle bundle = getArguments();
        if(bundle!=null) {
            mSearch = bundle.getString("search");
        }
        movieSearch();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if(bundle!=null) {
            mSearch = bundle.getString("search");
        }
        movieSearch();
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if(bundle!=null) {
            mSearch = bundle.getString("search");
        }
        movieSearch();
    }

    private void movieSearch(){
        for(int i=0; i<26; i++){
            mMovies.add(new Movie());
        }
        mAdapter.setMovieList(mMovies);
        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/")
                .build();
        MoviesApiService apiService = restAdapter.create(MoviesApiService.class);
        if(mSearch==null || mSearch.equals("")) {
            mCall = apiService.getPopularMovies();
        }else{
            mCall = apiService.getSearchedMovies(mSearch);
        }
        mCall.enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {
                mAdapter.setMovieList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
        mRecyclerView.addOnItemTouchListener(
                new MyRecyclerClicker(getActivity(), new MyRecyclerClicker.OnItemClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        List<Movie> movies = mAdapter.getMovieList();
                        FragmentManager fragmentManager = getFragmentManager();
                        Bundle bundle = new Bundle();
                        bundle.putString("movie_backdrop", movies.get(position).getBackdrop());
                        bundle.putString("movie_title", movies.get(position).getTitle());
                        bundle.putString("movie_description", movies.get(position).getDescription());
                        bundle.putString("movie_poster", movies.get(position).getPoster());

                        Fragment fragment = new DetailFragment();
                        fragment.setArguments(bundle);
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragHolder, fragment)
                                .addToBackStack(null)
                                .commit();

                    }
                }));
    }
}

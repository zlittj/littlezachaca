package com.zachlittle.android.aca.filmsearch;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";

    @SerializedName("title")
    private String mTitle;

    @SerializedName("poster_path")
    private String mPoster;

    @SerializedName("overview")
    private String mDescription;

    @SerializedName("backdrop_path")
    private String mBackdrop;

    public Movie(){}




    public String getBackdrop() {
        return TMDB_IMAGE_PATH+ mBackdrop;
    }

    public void setBackdrop(String backdrop) {
        mBackdrop = backdrop;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPoster() {
        return TMDB_IMAGE_PATH + mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }




    public static class MovieResult{
        private List<Movie> results;
        public List<Movie> getResults(){
            return results;
        }
    }
}

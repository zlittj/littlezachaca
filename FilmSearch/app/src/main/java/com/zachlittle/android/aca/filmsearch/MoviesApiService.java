package com.zachlittle.android.aca.filmsearch;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=971d52580fa91d4a43a6167e16b20340")
    Call<Movie.MovieResult> getPopularMovies();
}

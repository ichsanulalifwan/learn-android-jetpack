package com.dicoding.picodiploma.moviecatalogue2.data.network

import com.dicoding.picodiploma.moviecatalogue2.data.MovieResponse
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovie(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(
        @Query("api_key") apiKey: String
    ): Call<TvShowResponse>
}
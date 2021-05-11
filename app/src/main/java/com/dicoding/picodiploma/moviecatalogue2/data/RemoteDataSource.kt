package com.dicoding.picodiploma.moviecatalogue2.data

import com.dicoding.picodiploma.moviecatalogue2.BuildConfig
import com.dicoding.picodiploma.moviecatalogue2.data.network.ApiConfig
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse
import retrofit2.Call

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        private const val API_KEY = BuildConfig.Api_Key

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getPopularMovie(): Call<MovieResponse> = ApiConfig.getApiService().getMovie(API_KEY)

    fun getPopularTvShow(): Call<TvShowResponse> = ApiConfig.getApiService().getTvShow(API_KEY)

    fun getDetailMovie(movieId: Int): Call<MovieDetailResponse> =
        ApiConfig.getApiService().getDetailMovie(
            movieId,
            API_KEY
        )

    fun getDetailTvShow(tvId: Int): Call<TvShowDetailResponse> =
        ApiConfig.getApiService().getDetailTvShow(
            tvId,
            API_KEY
        )
}
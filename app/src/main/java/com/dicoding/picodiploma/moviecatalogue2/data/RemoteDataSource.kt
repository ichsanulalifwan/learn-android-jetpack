package com.dicoding.picodiploma.moviecatalogue2.data

import com.dicoding.picodiploma.moviecatalogue2.BuildConfig
import com.dicoding.picodiploma.moviecatalogue2.data.network.ApiConfig
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

    fun getPopularMovies(): Call<MovieResponse> {
        return ApiConfig.getApiService().getMovie(API_KEY)
    }
}
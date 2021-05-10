package com.dicoding.picodiploma.moviecatalogue2.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    companion object {
        @Volatile
        private var instance: MoviesRepository? = null

        private const val TAG = "MoviesRepository"

        fun getInstance(remoteDataSource: RemoteDataSource): MoviesRepository =
            instance ?: synchronized(this) {
                instance ?: MoviesRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getPopularMovie(): LiveData<List<MovieResultsItem>> {
        val movies = MutableLiveData<List<MovieResultsItem>>()
        remoteDataSource.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    movies.value = response.body()?.results as List<MovieResultsItem>
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    override fun getPopularTvShow(): LiveData<List<TvShowResultsItem>> {
        val tvShow = MutableLiveData<List<TvShowResultsItem>>()
        remoteDataSource.getPopularTvShow().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if (response.isSuccessful) {
                    tvShow.value = response.body()?.results as List<TvShowResultsItem>
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return tvShow
    }
}
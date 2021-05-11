package com.dicoding.picodiploma.moviecatalogue2.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.utils.EspressoIdlingResource
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
        EspressoIdlingResource.increment()
        val movies = MutableLiveData<List<MovieResultsItem>>()
        remoteDataSource.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    movies.value = response.body()?.results as List<MovieResultsItem>

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
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
        EspressoIdlingResource.increment()
        val tvShow = MutableLiveData<List<TvShowResultsItem>>()
        remoteDataSource.getPopularTvShow().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    tvShow.value = response.body()?.results as List<TvShowResultsItem>

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
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

    override fun getDetailMovie(movieId: Int): LiveData<MovieDetailResponse> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<MovieDetailResponse>()
        remoteDataSource.getDetailMovie(movieId).enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    detailMovie.value = response.body() as MovieDetailResponse

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return detailMovie
    }

    override fun getDetailTvShow(tvId: Int): LiveData<TvShowDetailResponse> {
        EspressoIdlingResource.increment()
        val detailTvShow = MutableLiveData<TvShowDetailResponse>()
        remoteDataSource.getDetailTvShow(tvId).enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    detailTvShow.value = response.body() as TvShowDetailResponse

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return detailTvShow
    }
}
package com.dicoding.picodiploma.moviecatalogue2.data

import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse

interface MoviesDataSource {

    fun getPopularMovie(): LiveData<List<MovieResultsItem>>

    fun getPopularTvShow(): LiveData<List<TvShowResultsItem>>

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailResponse>

    fun getDetailTvShow(tvId: Int): LiveData<TvShowDetailResponse>
}
package com.dicoding.picodiploma.moviecatalogue2.data

import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.moviecatalogue2.data.response.*

interface MoviesDataSource {

    fun getPopularMovie(): LiveData<List<MovieResultsItem>>

    fun getPopularTvShow(): LiveData<List<TvShowResultsItem>>

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailResponse>

    fun getDetailTvShow(tvId: Int): LiveData<TvShowDetailResponse>

    fun getMovieGenres(movieId: Int): LiveData<List<GenresItem>>

    fun getTvGenres(tvId: Int): LiveData<List<GenresItem>>
}
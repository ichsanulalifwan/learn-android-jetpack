package com.dicoding.picodiploma.moviecatalogue2.data

import androidx.lifecycle.LiveData

interface MoviesDataSource {

    fun getPopularMovie(): LiveData<List<MovieResultsItem>>

    fun getPopularTvShow(): LiveData<List<TvShowResultsItem>>
}
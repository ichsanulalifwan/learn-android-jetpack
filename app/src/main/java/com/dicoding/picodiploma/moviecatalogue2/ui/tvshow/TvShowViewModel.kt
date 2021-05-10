package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem

class TvShowViewModel(private val repository: MoviesRepository) : ViewModel() {

    fun getPopularTvShow(): LiveData<List<TvShowResultsItem>> = repository.getPopularTvShow()
}
package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository

class MovieViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    fun getPopularMovie(): LiveData<List<MovieResultsItem>> = moviesRepository.getPopularMovie()
}
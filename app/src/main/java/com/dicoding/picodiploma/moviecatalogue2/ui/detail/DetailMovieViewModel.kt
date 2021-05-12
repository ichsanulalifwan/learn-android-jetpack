package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse

class DetailMovieViewModel(private val repository: MoviesRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailResponse> =
        repository.getDetailMovie(movieId)

    fun getMovieGenres(movieId: Int): LiveData<List<GenresItem>> =
        repository.getMovieGenres(movieId)
}
package com.dicoding.picodiploma.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue.data.MovieEntity
import com.dicoding.picodiploma.moviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movieEntity: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movie in movieEntities) {
            if (movie.movieId == movieId) {
                movieEntity = movie
            }
        }
        return movieEntity
    }
}
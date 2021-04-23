package com.dicoding.picodiploma.moviecatalogue.ui.detail

import com.dicoding.picodiploma.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setMovie() {
        viewModel = DetailMovieViewModel()
        viewModel.setMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.quote, movieEntity.quote)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.date, movieEntity.date)
        assertEquals(dummyMovie.poster, movieEntity.poster)
    }
}
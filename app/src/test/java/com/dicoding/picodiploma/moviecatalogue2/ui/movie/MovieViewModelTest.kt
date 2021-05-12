package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest : TestCase() {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    override fun setUp() {
        viewModel = MovieViewModel(moviesRepository)
    }

    @Test
    fun testGetPopularMovie() {
        val movieResult = viewModel.getPopularMovie()
        assertNotNull(movieResult)
    }
}
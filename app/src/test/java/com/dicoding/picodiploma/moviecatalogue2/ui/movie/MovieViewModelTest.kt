package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<List<MovieResultsItem>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(moviesRepository)
    }

    @Test
    fun getPopularMovie() {

        val dummyMovies = DataDummy.generateDummyMovies()
        val movie = MutableLiveData<List<MovieResultsItem>>()
        movie.value = dummyMovies

        `when`(moviesRepository.getPopularMovie()).thenReturn(movie)
        val movieEntities = viewModel.getPopularMovie().value

        verify(moviesRepository).getPopularMovie()
        assertNotNull(movieEntities)
        assertEquals(3, movieEntities?.size)

        viewModel.getPopularMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}
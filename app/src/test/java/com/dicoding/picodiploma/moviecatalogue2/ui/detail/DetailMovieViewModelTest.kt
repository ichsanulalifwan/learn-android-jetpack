package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyDetailMovies()[0]
    private val dummyGenre = DataDummy.generateDummyGenres()
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieDetailResponse>

    @Mock
    private lateinit var genreObserver: Observer<List<GenresItem>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(moviesRepository)
        viewModel.getDetailMovie(movieId)
        viewModel.getMovieGenres(movieId)
    }

    @Test
    fun getDetailMovie() {

        val detailMovie = MutableLiveData<MovieDetailResponse>()
        detailMovie.value = dummyMovie

        `when`(moviesRepository.getDetailMovie(movieId)).thenReturn(detailMovie)
        val movieEntity = viewModel.getDetailMovie(movieId).value as MovieDetailResponse
        verify(moviesRepository, times(2)).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genres, movieEntity.genres)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.tagline, movieEntity.tagline)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.status, movieEntity.status)

        viewModel.getDetailMovie(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getMovieGenres() {

        val genreItem = MutableLiveData<List<GenresItem>>()
        genreItem.value = dummyGenre

        `when`(moviesRepository.getMovieGenres(movieId)).thenReturn(genreItem)
        val genreEntities = viewModel.getMovieGenres(movieId).value

        verify(moviesRepository, times(2)).getMovieGenres(movieId)
        assertNotNull(genreEntities)
        assertEquals(4, genreEntities?.size)

        viewModel.getMovieGenres(movieId).observeForever(genreObserver)
        verify(genreObserver).onChanged(dummyGenre)
    }
}
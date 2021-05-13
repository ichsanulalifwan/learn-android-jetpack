package com.dicoding.picodiploma.moviecatalogue2.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.picodiploma.moviecatalogue2.utils.DataDummy
import com.dicoding.picodiploma.moviecatalogue2.utils.LiveDataTestUtil
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.*
import retrofit2.Response

class MoviesRepositoryTest {

    private lateinit var moviesRepository: FakeMoviesRepository
    private val remote = mock(RemoteDataSource::class.java, RETURNS_DEEP_STUBS)
    private val movieResponses = DataDummy.generateDummyMovies()
    private val tvResponses = DataDummy.generateDummyTvShow()
    private val detailMovie = DataDummy.generateDummyDetailMovies()[0]
    private val movieId = detailMovie.id
    private val detailTv = DataDummy.generateDummyDetailTv()[0]
    private val tvId = detailTv.id
    private val dummyGenre = DataDummy.generateDummyGenres()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        moviesRepository = FakeMoviesRepository(remote)
    }

    @Test
    fun getPopularMovie() {

        `when`(remote.getPopularMovie().execute()).thenReturn(
            Response.success(
                MovieResponse(
                    movieResponses
                )
            )
        )

        val movieEntities = LiveDataTestUtil.getValue(moviesRepository.getPopularMovie())

        verify(remote, times(2)).getPopularMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size, movieEntities.size)
    }

    @Test
    fun getPopularTvShow() {

        `when`(remote.getPopularTvShow().execute()).thenReturn(
            Response.success(
                TvShowResponse(
                    tvResponses
                )
            )
        )

        val tvEntities = LiveDataTestUtil.getValue(moviesRepository.getPopularTvShow())

        verify(remote, times(2)).getPopularTvShow()
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size, tvEntities.size)
    }

    @Test
    fun getDetailMovie() {

        `when`(remote.getDetailMovie(movieId).execute()).thenReturn(Response.success(detailMovie))

        val detailMovieEntities =
            LiveDataTestUtil.getValue(moviesRepository.getDetailMovie(movieId))

        verify(remote, times(2)).getDetailMovie(movieId)
        assertNotNull(detailMovieEntities)
        assertEquals(detailMovie.id, detailMovieEntities.id)
    }

    @Test
    fun getDetailTvShow() {

        `when`(remote.getDetailTvShow(tvId).execute()).thenReturn(Response.success(detailTv))

        val detailTvEntities = LiveDataTestUtil.getValue(moviesRepository.getDetailTvShow(tvId))

        verify(remote, times(2)).getDetailTvShow(tvId)
        assertNotNull(detailTvEntities)
        assertEquals(detailTv.id, detailTvEntities.id)
    }

    @Test
    fun getMovieGenres() {

        `when`(remote.getDetailMovie(movieId).execute().body()?.genres).thenReturn(dummyGenre)

        val genreMovieEntities = LiveDataTestUtil.getValue(moviesRepository.getMovieGenres(movieId))

        verify(remote, times(2)).getDetailMovie(movieId)
        assertNotNull(genreMovieEntities)
        assertEquals(dummyGenre.size.toLong(), genreMovieEntities.size.toLong())
    }

    @Test
    fun getTvGenres() {

        `when`(remote.getDetailTvShow(tvId).execute().body()?.genres).thenReturn(dummyGenre)

        val genreTvEntities = LiveDataTestUtil.getValue(moviesRepository.getTvGenres(tvId))

        verify(remote, times(2)).getDetailTvShow(tvId)
        assertNotNull(genreTvEntities)
        assertEquals(dummyGenre.size.toLong(), genreTvEntities.size.toLong())
    }
}
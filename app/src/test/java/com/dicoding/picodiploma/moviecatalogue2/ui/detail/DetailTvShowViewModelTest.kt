package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.utils.DataDummy
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTv = DataDummy.generateDummyDetailTv()[0]
    private val tvId = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: MoviesRepository

    @Mock
    private lateinit var tvObserver: Observer<TvShowDetailResponse>

    @Mock
    private lateinit var genreObserver: Observer<List<GenresItem>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(tvRepository)
        viewModel.getDetailTv(tvId)
        viewModel.getTvGenres(tvId)
    }

    @Test
    fun getDetailTv() {
        val detailTv = MutableLiveData<TvShowDetailResponse>()
        detailTv.value = dummyTv

        `when`(tvRepository.getDetailTvShow(tvId)).thenReturn(detailTv)
        val tvEntity = viewModel.getDetailTv(tvId).value as TvShowDetailResponse
        verify(tvRepository, times(2)).getDetailTvShow(tvId)
        assertNotNull(tvEntity)
        assertEquals(dummyTv.firstAirDate, tvEntity.firstAirDate)
        assertEquals(dummyTv.overview, tvEntity.overview)
        assertEquals(dummyTv.numberOfEpisodes, tvEntity.numberOfEpisodes)
        assertEquals(dummyTv.type, tvEntity.type)
        assertEquals(dummyTv.posterPath, tvEntity.posterPath)
        assertEquals(dummyTv.genres, tvEntity.genres)
        assertEquals(dummyTv.voteAverage, tvEntity.voteAverage)
        assertEquals(dummyTv.name, tvEntity.name)
        assertEquals(dummyTv.tagline, tvEntity.tagline)
        assertEquals(dummyTv.id, tvEntity.id)
        assertEquals(dummyTv.numberOfSeasons, tvEntity.numberOfSeasons)
        assertEquals(dummyTv.status, tvEntity.status)

        viewModel.getDetailTv(tvId).observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTv)
    }

    @Test
    fun getTvGenres() {
        val dummyGenre = DataDummy.generateDummyGenres()
        val genreItem = MutableLiveData<List<GenresItem>>()
        genreItem.value = dummyGenre

        `when`(tvRepository.getTvGenres(tvId)).thenReturn(genreItem)
        val genreEntities = viewModel.getTvGenres(tvId).value

        verify(tvRepository, times(2)).getTvGenres(tvId)
        assertNotNull(genreEntities)
        assertEquals(3, genreEntities?.size)

        viewModel.getTvGenres(tvId).observeForever(genreObserver)
        Mockito.verify(genreObserver).onChanged(dummyGenre)
    }
}
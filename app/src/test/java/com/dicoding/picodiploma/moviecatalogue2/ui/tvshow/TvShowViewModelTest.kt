package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowResultsItem>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(moviesRepository)
    }

    @Test
    fun getPopularTvShow() {
        val dummyTv = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<TvShowResultsItem>>()
        tvShow.value = dummyTv

        Mockito.`when`(moviesRepository.getPopularTvShow()).thenReturn(tvShow)
        val tvEntities = viewModel.getPopularTvShow().value
        Mockito.verify(moviesRepository).getPopularTvShow()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(3, tvEntities?.size)

        viewModel.getPopularTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }
}
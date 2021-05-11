package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse

class DetailTvShowViewModel(private val repository: MoviesRepository) : ViewModel() {

    fun getDetailTv(tvId: Int): LiveData<TvShowDetailResponse> = repository.getDetailTvShow(tvId)
}
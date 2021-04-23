package com.dicoding.picodiploma.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue.data.TvShowEntity
import com.dicoding.picodiploma.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}
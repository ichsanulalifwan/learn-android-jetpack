package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalogue2.BuildConfig
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResponse
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowViewModel : ViewModel() {

    private val _tvShow = MutableLiveData<List<TvShowResultsItem>>()
    val tvShow: LiveData<List<TvShowResultsItem>> = _tvShow

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        private const val TAG = "TvShowViewModel"
        private const val API_KEY = BuildConfig.Api_Key
    }

    fun getPopularTvShow() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getTvShow(API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {

            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _tvShow.value = response.body()?.results
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}
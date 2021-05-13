package com.dicoding.picodiploma.moviecatalogue2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.moviecatalogue2.data.response.*

class FakeMoviesRepository(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    // use fake method for synchronous API call when testing
    override fun getPopularMovie(): LiveData<List<MovieResultsItem>> {

        val movies = MutableLiveData<List<MovieResultsItem>>()
        movies.value = remoteDataSource.getPopularMovie().execute().body()?.results
        return movies
    }

    // use fake method for synchronous API call when testing
    override fun getPopularTvShow(): LiveData<List<TvShowResultsItem>> {

        val tvShow = MutableLiveData<List<TvShowResultsItem>>()
        tvShow.value = remoteDataSource.getPopularTvShow().execute().body()?.results
        return tvShow
    }

    // use fake method for synchronous API call when testing
    override fun getDetailMovie(movieId: Int): LiveData<MovieDetailResponse> {

        val detailMovie = MutableLiveData<MovieDetailResponse>()
        detailMovie.value = remoteDataSource.getDetailMovie(movieId).execute().body()
        return detailMovie
    }

    // use fake method for synchronous API call when testing
    override fun getDetailTvShow(tvId: Int): LiveData<TvShowDetailResponse> {

        val detailTvShow = MutableLiveData<TvShowDetailResponse>()
        detailTvShow.value = remoteDataSource.getDetailTvShow(tvId).execute().body()
        return detailTvShow
    }

    // use fake method for synchronous API call when testing
    override fun getMovieGenres(movieId: Int): LiveData<List<GenresItem>> {

        val movieGenres = MutableLiveData<List<GenresItem>>()
        movieGenres.value = remoteDataSource.getDetailMovie(movieId).execute().body()?.genres
        return movieGenres
    }

    // use fake method for synchronous API call when testing
    override fun getTvGenres(tvId: Int): LiveData<List<GenresItem>> {

        val tvGenres = MutableLiveData<List<GenresItem>>()
        tvGenres.value = remoteDataSource.getDetailTvShow(tvId).execute().body()?.genres
        return tvGenres
    }
}
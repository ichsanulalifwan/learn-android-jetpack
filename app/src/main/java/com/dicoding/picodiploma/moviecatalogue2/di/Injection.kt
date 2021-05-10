package com.dicoding.picodiploma.moviecatalogue2.di

import com.dicoding.picodiploma.moviecatalogue2.data.MoviesRepository
import com.dicoding.picodiploma.moviecatalogue2.data.RemoteDataSource

object Injection {

    fun provideRepository(): MoviesRepository {

        val remoteRepo = RemoteDataSource.getInstance()

        return MoviesRepository.getInstance(remoteRepo)
    }
}
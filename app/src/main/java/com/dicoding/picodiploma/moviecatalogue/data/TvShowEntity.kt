package com.dicoding.picodiploma.moviecatalogue.data

data class TvShowEntity(
        var tvShowId: String,
        var title: String,
        var genre: String,
        var quote: String,
        var overview: String,
        var runtime: String,
        var date: Int,
        var season: Int,
        var poster: Int
)

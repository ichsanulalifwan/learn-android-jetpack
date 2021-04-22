package com.dicoding.picodiploma.moviecatalogue.data

data class MovieEntity(
        var title: String,
        var genre: String,
        var quote: String,
        var overview: String,
        var runtime: String,
        var date: Int,
        var poster: Int
)

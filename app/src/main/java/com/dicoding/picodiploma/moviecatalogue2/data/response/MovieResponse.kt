package com.dicoding.picodiploma.moviecatalogue2.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("results")
    var results: List<MovieResultsItem>
)

data class MovieResultsItem(

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String
)

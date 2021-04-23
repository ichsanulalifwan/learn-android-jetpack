package com.dicoding.picodiploma.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.picodiploma.moviecatalogue.data.MovieEntity
import com.dicoding.picodiploma.moviecatalogue.databinding.ActivityMovieDetailBinding
import com.dicoding.picodiploma.moviecatalogue.utils.DataDummy

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            movieId?.let {
                for (movie in DataDummy.generateDummyMovies()) {
                    if (movie.movieId == it) {
                        populateData(movie)
                    }
                }
            }
        }
    }

    private fun populateData(movie: MovieEntity) {
        binding.apply {
            tvTitleMovie.text = movie.title
            tvYear.text = movie.date.toString()
            tvRuntime.text = movie.runtime
            tvGenre.text = movie.genre
            tvQuotes.text = movie.quote
            tvOverview.text = movie.overview

            Glide.with(this@DetailMovieActivity)
                .load(movie.poster)
                .transform(RoundedCorners(20))
                .into(imgPosterDetail)
        }
    }
}
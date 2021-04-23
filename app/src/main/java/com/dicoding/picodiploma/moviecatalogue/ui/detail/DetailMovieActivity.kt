package com.dicoding.picodiploma.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.picodiploma.moviecatalogue.R
import com.dicoding.picodiploma.moviecatalogue.data.MovieEntity
import com.dicoding.picodiploma.moviecatalogue.databinding.ActivityMovieDetailBinding

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


        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            movieId?.let {
                viewModel.setMovie(it)
                populateData(viewModel.getMovie())
                supportActionBar?.title = viewModel.getMovie().title
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
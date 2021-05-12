package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.moviecatalogue2.R
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.databinding.ActivityDetailMovieBinding
import com.dicoding.picodiploma.moviecatalogue2.ui.movie.MovieAdapter.Companion.IMAGE_PREFIX
import com.dicoding.picodiploma.moviecatalogue2.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var genresAdapter: GenresAdapter

    companion object {
        const val EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showLoading(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        genresAdapter = GenresAdapter()

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE_ID)
            viewModel.getDetailMovie(movieId).observe(this, { movie ->
                populateData(movie)
                showLoading(false)
                title = movie.title
            })

            viewModel.getMovieGenres(movieId).observe(this, {
                getGenres(it)
            })
        }
    }

    private fun populateData(movie: MovieDetailResponse) {
        binding.apply {
            tvOverview.text = movie.overview
            tvRelase.text = movie.releaseDate
            tvVote.text = movie.voteAverage.toString()
            tvRuntime.text = movie.runtime.toString()
            tvTagline.text = movie.tagline
            tvTitleMovie.text = movie.title
            tvStatus.text = movie.status

            Glide.with(this@DetailMovieActivity)
                .load(IMAGE_PREFIX + movie.posterPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.movie_poster))
                .into(imgPosterMovie)
        }
    }

    private fun getGenres(genres: List<GenresItem>) {
        genresAdapter.setData(genres)
        with(binding.rvGenres) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = genresAdapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}
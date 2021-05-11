package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.moviecatalogue2.R
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.databinding.ActivityDetailTvShowBinding
import com.dicoding.picodiploma.moviecatalogue2.ui.movie.MovieAdapter.Companion.IMAGE_PREFIX
import com.dicoding.picodiploma.moviecatalogue2.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvShowBinding

    companion object {
        const val EXTRA_TV_ID = "EXTRA_TV_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showLoading(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getInt(EXTRA_TV_ID)
            viewModel.getDetailTv(tvId).observe(this, { tv ->
                populateData(tv)
                showLoading(false)
                title = tv.name
            })
        }
    }

    private fun populateData(tvshow: TvShowDetailResponse) {
        binding.apply {
            tvTitleTvShow.text = tvshow.name
            tvFirstAir.text = tvshow.firstAirDate
            tvSeason.text = tvshow.numberOfSeasons.toString()
            tvGenre.text = tvshow.genres.toString()
            tvTaglineTv.text = tvshow.tagline
            tvRuntime.text = tvshow.episodeRunTime.toString()
            tvOverview.text = tvshow.overview

            Glide.with(this@DetailTvShowActivity)
                .load(IMAGE_PREFIX + tvshow.posterPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.movie_poster))
                .into(imgPosterTv)
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
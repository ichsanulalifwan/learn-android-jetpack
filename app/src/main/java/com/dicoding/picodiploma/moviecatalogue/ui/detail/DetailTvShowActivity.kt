package com.dicoding.picodiploma.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.picodiploma.moviecatalogue.data.TvShowEntity
import com.dicoding.picodiploma.moviecatalogue.databinding.ActivityDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvShowBinding

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TVSHOW)
            tvShowId?.let {
                viewModel.setTvShow(it)
                populateData(viewModel.getTvShow())
            }
        }
    }

    private fun populateData(tvshow: TvShowEntity) {
        binding.apply {
            tvTitleTvShow.text = tvshow.title
            tvYear.text = tvshow.date.toString()
            tvSeason.text = tvshow.season.toString()
            tvGenre.text = tvshow.genre
            tvQuotes.text = tvshow.quote
            tvRuntime.text = tvshow.runtime
            tvOverview.text = tvshow.overview

            Glide.with(this@DetailTvShowActivity)
                .load(tvshow.poster)
                .transform(RoundedCorners(20))
                .into(imgPosterDetail)
        }
    }
}
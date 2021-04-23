package com.dicoding.picodiploma.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.picodiploma.moviecatalogue.data.TvShowEntity
import com.dicoding.picodiploma.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.dicoding.picodiploma.moviecatalogue.utils.DataDummy

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

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(DetailTvShowActivity.EXTRA_TVSHOW)
            tvShowId?.let {
                for (tvshow in DataDummy.generateDummyTvShow()) {
                    if (tvshow.tvShowId == it) {
                        populateData(tvshow)
                    }
                }
            }
        }
    }

    private fun populateData(tvshow: TvShowEntity) {
        binding.apply {
            tvTitleMovie.text = tvshow.title
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
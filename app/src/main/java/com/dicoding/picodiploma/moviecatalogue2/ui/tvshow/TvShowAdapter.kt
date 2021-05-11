package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.picodiploma.moviecatalogue2.R
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.databinding.ItemListBinding
import com.dicoding.picodiploma.moviecatalogue2.ui.movie.MovieAdapter.Companion.IMAGE_PREFIX

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener
    private var listTvShow = ArrayList<TvShowResultsItem>()

    fun setDataTvShow(tvshows: List<TvShowResultsItem>?) {
        if (tvshows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvshows)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvshowBinding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return TvShowViewHolder(itemTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size

    inner class TvShowViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshow: TvShowResultsItem) {
            with(binding) {
                tvTitle.text = tvshow.name
                tvRelaseDate.text = tvshow.firstAirDate
                tvOverviewItem.text = tvshow.overview
                itemView.setOnClickListener {
                    onItemClickListener.onTvShowClicked(tvshow)
                }

                Glide.with(itemView.context)
                    .load(IMAGE_PREFIX + tvshow.posterPath)
                    .centerCrop()
                    .placeholder(R.drawable.movie_poster)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgPoster)
            }
        }
    }

    interface OnItemClickListener {
        fun onTvShowClicked(tvshow: TvShowResultsItem)
    }
}
package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.moviecatalogue2.databinding.ItemTvshowBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class TvShowViewHolder(private val binding: ItemTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*fun bind(tvshow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvshow.title
                tvGenre.text = tvshow.genre
                numberOfSeason.text = tvshow.season.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvshow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvshow.poster)
                    .centerCrop()
                    .into(imgPoster)
            }*/
        }

    /*private var listTvShow = ArrayList<TvShowEntity>()

    fun setDataTvShow(tvshows: List<TvShowEntity>?) {
        if (tvshows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvshowBinding = ItemTvshowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return TvShowViewHolder(itemTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvshow.title
                tvGenre.text = tvshow.genre
                numberOfSeason.text = tvshow.season.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvshow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvshow.poster)
                    .centerCrop()
                    .into(imgPoster)
            }
        }
    }*/
}
package com.dicoding.picodiploma.moviecatalogue2.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.databinding.ItemGenreBinding

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    private var listGenres = ArrayList<GenresItem>()

    inner class GenresViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genre: GenresItem) {
            with(binding) {
                tvGenres.text = genre.name
            }
        }
    }

    fun setData(genres: List<GenresItem>?) {
        if (genres == null) return
        this.listGenres.clear()
        this.listGenres.addAll(genres)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val itemGenreBinding = ItemGenreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return GenresViewHolder(itemGenreBinding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.bind(listGenres[position])
    }

    override fun getItemCount(): Int = listGenres.size
}
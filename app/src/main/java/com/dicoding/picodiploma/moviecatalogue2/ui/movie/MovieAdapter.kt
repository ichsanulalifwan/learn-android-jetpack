package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.databinding.ItemListBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<MovieResultsItem>()

    companion object{
        const val IMAGE_PREFIX = "https://image.tmdb.org/t/p/original"
    }

    fun setDataMovies(movies: List<MovieResultsItem>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieResultsItem) {
            with(binding) {
                tvTitle.text = movie.title
                tvRelaseDate.text = movie.releaseDate
                tvSummary.text = movie.overview
                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }*/

                Glide.with(itemView.context)
                    .load(IMAGE_PREFIX + movie.posterPath)
                    .centerCrop()
                    .into(imgPoster)
            }
        }
    }
}
package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.databinding.FragmentMovieBinding
import com.dicoding.picodiploma.moviecatalogue2.ui.detail.DetailMovieActivity
import com.dicoding.picodiploma.moviecatalogue2.ui.detail.DetailMovieActivity.Companion.EXTRA_MOVIE_ID
import com.dicoding.picodiploma.moviecatalogue2.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            movieAdapter = MovieAdapter()
            setupRecyclerView()
            showLoading(true)

            viewModel.getPopularMovie().observe(viewLifecycleOwner, {
                movieAdapter.setDataMovies(it)
                showLoading(false)
            })

            onMovieSelected()
        }
    }

    private fun setupRecyclerView() {
        with(fragmentMovieBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun onMovieSelected() {
        movieAdapter.setOnItemClickListener(object : MovieAdapter.OnItemClickListener {
            override fun onMovieClicked(movie: MovieResultsItem) {
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_MOVIE_ID, movie.id)
                startActivity(intent)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentMovieBinding.progressBar.visibility = View.GONE
        }
    }
}
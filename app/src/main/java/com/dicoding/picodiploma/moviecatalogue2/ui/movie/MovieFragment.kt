package com.dicoding.picodiploma.moviecatalogue2.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.moviecatalogue2.databinding.FragmentMovieBinding
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
            showLoading(true)

            viewModel.getPopularMovie().observe(viewLifecycleOwner, {
                    movieAdapter.setDataMovies(it)
                    showLoading(false)
            })

            /*movieViewModel.isLoading.observe(viewLifecycleOwner, {
                if (it) showLoading(true)
                else showLoading(false)
            })*/

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentMovieBinding.progressBar.visibility = View.GONE
        }
    }
}
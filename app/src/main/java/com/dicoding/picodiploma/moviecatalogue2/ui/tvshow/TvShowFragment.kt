package com.dicoding.picodiploma.moviecatalogue2.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.databinding.FragmentTvShowBinding
import com.dicoding.picodiploma.moviecatalogue2.ui.detail.DetailTvShowActivity
import com.dicoding.picodiploma.moviecatalogue2.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            tvShowAdapter = TvShowAdapter()
            setupRecyclerView()
            showLoading(true)

            viewModel.getPopularTvShow().observe(viewLifecycleOwner, {
                tvShowAdapter.setDataTvShow(it)
                showLoading(false)
            })

            onTvShowSelected()
        }
    }

    private fun setupRecyclerView() {
        with(fragmentTvShowBinding.rvTvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    private fun onTvShowSelected() {
        tvShowAdapter.setOnItemClickListener(object : TvShowAdapter.OnItemClickListener {
            override fun onTvShowClicked(tvshow: TvShowResultsItem) {
                val intent = Intent(context, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_TV_ID, tvshow.id)
                startActivity(intent)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentTvShowBinding.progressBar.visibility = View.GONE
        }
    }
}
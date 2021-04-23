package com.dicoding.picodiploma.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.moviecatalogue.adapter.SectionsPagerAdapter
import com.dicoding.picodiploma.moviecatalogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionsPagerAdapter
        activityMainBinding.tablayout.setupWithViewPager(activityMainBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}
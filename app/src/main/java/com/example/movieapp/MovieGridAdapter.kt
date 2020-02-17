package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.MovieGridLayoutBinding

class MovieGridAdapter: RecyclerView.Adapter<MovieGridAdapter.MovieGridHolder>() {
    lateinit var binding: MovieGridLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGridHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_grid_layout, parent, false)
        return MovieGridHolder(binding)

    }

    override fun getItemCount() = 2

    override fun onBindViewHolder(holder: MovieGridHolder, position: Int) {

    }

    class MovieGridHolder(binding: MovieGridLayoutBinding): RecyclerView.ViewHolder(binding.root)  {

    }
}
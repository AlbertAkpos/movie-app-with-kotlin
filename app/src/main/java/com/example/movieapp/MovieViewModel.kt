package com.example.movieapp

import androidx.lifecycle.ViewModel

class MovieViewModel(id: Long?): ViewModel() {
    var movies = MovieRepository.get().getMovies()
    var movie = MovieRepository.get().getMovie(id!!)
}
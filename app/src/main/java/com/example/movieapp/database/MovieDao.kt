package com.example.movieapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieapp.Movie


@Dao
interface MovieDao {
    @Query(value = "SELECT * FROM movie_table")
    fun getMovies(): LiveData<List<Movie>>

    @Query(value = "SELECT * FROM movie_table WHERE id=(:id)")
    fun getMovie(id: Long): LiveData<Movie>

    @Insert
    fun addMovies(vararg movies: Movie)

}
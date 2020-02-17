package com.example.movieapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.movieapp.database.MovieDatabase
import java.lang.IllegalStateException


private const val DATABASE_NAME = "movie_database"
class MovieRepository private constructor(context: Context){

    private val database: MovieDatabase = Room.databaseBuilder(
        context.applicationContext,
        MovieDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val movieDao = database.movieDao()

    //functions that communicate with the database
    fun getMovies(): LiveData<List<Movie>> = movieDao.getMovies()
    fun getMovie(id: Long): LiveData<Movie> = movieDao.getMovie(id)
    fun addMovies(vararg movies: Movie) = movieDao.addMovies(*movies)

    companion object {
        private var INSTANCE: MovieRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = MovieRepository(context)
            }
        }

        fun get(): MovieRepository {
            return INSTANCE ?:
                    throw IllegalStateException("Movie repository must be initialized")
        }
    }

}
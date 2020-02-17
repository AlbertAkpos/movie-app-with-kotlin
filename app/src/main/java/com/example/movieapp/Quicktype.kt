package com.example.movieapp

import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Welcome (
    val page: Long,

    @SerialName("total_results")
    val total_results: Long,

    @SerialName("total_pages")
    val total_pages: Long,

    val movies: List<Movie>
)


@Entity(tableName = "movie_table")
@Serializable
data class Movie (
    val popularity: Double,

    @SerialName("vote_count")
    val vote_count: Long,

    val video: Boolean,

    @SerialName("poster_path")
    val poster_path: String,

    val id: Long,
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdrop_path: String,

    @SerialName("original_language")
    val original_language: String,

    val title: String,

    @SerialName("vote_average")
    val vote_average: Double,

    val overview: String,

    @SerialName("release_date")
    val releaseDate: String
)
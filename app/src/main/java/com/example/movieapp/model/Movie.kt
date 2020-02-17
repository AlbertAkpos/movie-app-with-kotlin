package com.example.movieapp.model

import kotlinx.serialization.SerialName


data class Movie (
    val popularity: Double,

    val vote_count: Long,

    val video: Boolean,

    val poster_path: String,

    val id: Long,
    val adult: Boolean,

    val backdrop_path: String,

    val original_language: String,

    val title: String,

    val vote_average: Double,

    val overview: String,

    val releaseDate: String
)
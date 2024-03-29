package com.arctouch.codechallenge.model

import com.squareup.moshi.Json
import java.io.Serializable

data class GenreResponse(val genres: MutableList<Genre>)

data class Genre(val id: Int, val name: String) : Serializable

data class UpcomingMoviesResponse(
    val page: Int,
    val results: MutableList<Movie>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String?,
    val genres: List<Genre>?,
    @Json(name = "genre_ids") val genreIds: List<Int>?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "release_date") val releaseDate: String?
) : Serializable

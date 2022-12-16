package com.fox.myfavoritmovieapp.data.model.movie

data class Poster(
    val posters: List<Artwork> = emptyList(),
    val backdrops: List<Artwork> = emptyList()
)

data class Artwork(
    val language: String?,
    val url: String?,
    val height: Int?,
    val width: Int?
)

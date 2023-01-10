package com.fox.myfavoritmovieapp.domain.model.movie.video.tvshow

data class Season(
    val number: Int,
    val episodes: List<com.fox.myfavoritmovieapp.domain.model.movie.video.tvshow.Episode> = emptyList()
)

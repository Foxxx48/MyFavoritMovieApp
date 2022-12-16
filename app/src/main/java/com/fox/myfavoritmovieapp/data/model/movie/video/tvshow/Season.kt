package com.fox.myfavoritmovieapp.data.model.movie.video.tvshow

data class Season(
    val number: Int,
    val episodes: List<Episode> = emptyList()
)

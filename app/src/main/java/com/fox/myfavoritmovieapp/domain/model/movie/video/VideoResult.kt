package com.fox.myfavoritmovieapp.domain.model.movie.video

data class VideoResult(
    val trailers: List<VideoItem> = emptyList(),
    val teasers: List<VideoItem> = emptyList()
)

package com.fox.myfavoritmovieapp.data.model.movie.video

data class VideoResult(
    val trailers: List<VideoItem> = emptyList(),
    val teasers: List<VideoItem> = emptyList()
)

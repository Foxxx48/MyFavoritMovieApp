package com.fox.myfavoritmovieapp.domain.model.movie.video

data class VideoResult(
    val trailers: List<com.fox.myfavoritmovieapp.domain.model.movie.video.VideoItem> = emptyList(),
    val teasers: List<com.fox.myfavoritmovieapp.domain.model.movie.video.VideoItem> = emptyList()
)

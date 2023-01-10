package com.fox.myfavoritmovieapp.domain.model.top.movie

data class TopResult(
    val pagesCount: Int = 0,
    val films: List<TopItem> = emptyList()
)

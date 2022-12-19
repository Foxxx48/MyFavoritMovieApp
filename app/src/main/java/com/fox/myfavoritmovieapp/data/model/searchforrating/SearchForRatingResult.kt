package com.fox.myfavoritmovieapp.data.model.searchforrating

import com.fox.myfavoritmovieapp.data.model.search.movie.keyword.SearchItem

data class SearchForRatingResult(
    val total: String?,
    val totalPages: Int,
    val items: List<SearchForRatingItem> = emptyList(),
)

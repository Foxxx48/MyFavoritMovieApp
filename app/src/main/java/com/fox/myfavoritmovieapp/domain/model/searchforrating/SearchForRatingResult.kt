package com.fox.myfavoritmovieapp.domain.model.searchforrating



data class SearchForRatingResult(
    val total: String?,
    val totalPages: Int,
    val items: List<SearchForRatingItem> = emptyList(),
)

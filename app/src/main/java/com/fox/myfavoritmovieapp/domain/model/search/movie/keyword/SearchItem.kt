package com.fox.myfavoritmovieapp.domain.model.search.movie.keyword

import com.fasterxml.jackson.annotation.JsonProperty
import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre
import com.fox.myfavoritmovieapp.domain.model.common.KinopoiskItemType


data class SearchItem(
    @JsonProperty("filmId")
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val type: KinopoiskItemType = KinopoiskItemType.UNKNOWN,
    val year: String?,
    val description: String?,
    val filmLength: String?,
    val countries: List<Country> = emptyList(),
    val genres: List<Genre> = emptyList(),
    val rating: String?,
    val ratingVoteCount: Int?,
    val posterUrl: String,
    val posterUrlPreview: String
)

package com.fox.myfavoritmovieapp.domain.model.movie.related

import com.fasterxml.jackson.annotation.JsonProperty

data class RelatedFilmItem(
    @JsonProperty("filmId")
    val kinopoiskId: Int,
    var nameRu: String?,
    var nameEn: String?,
    val posterUrl: String,
    val posterUrlPreview: String,
    var relationType: com.fox.myfavoritmovieapp.domain.model.movie.related.SequelOrPrequel
)

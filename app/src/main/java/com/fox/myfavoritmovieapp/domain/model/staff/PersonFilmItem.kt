package com.fox.myfavoritmovieapp.domain.model.staff

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonFilmItem(
    @JsonProperty("filmId")
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val rating: String?, // can be percent if film has not been released
    val general: Boolean,
    val description: String?,
    val professionKey: Profession
)

package com.fox.myfavoritmovieapp.domain.model.movie
import com.fasterxml.jackson.annotation.JsonProperty
import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre
import com.fox.myfavoritmovieapp.domain.model.common.KinopoiskItemType
import com.fox.myfavoritmovieapp.domain.model.movie.video.tvshow.Season

import java.time.LocalDate

data class Common(
    @JsonProperty("filmId")
    val kinopoiskId: Int,
    var nameRu: String,
    var nameEn: String,
    val webUrl: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: String,
    var filmLength: String?,
    var slogan: String?,
    var description: String?,
    var type: KinopoiskItemType,
    var ratingMpaa: String?,
    var ratingAgeLimits: Int?,
    var premiereRu: LocalDate?,
    var distributors: String?,
    var premiereWorld: LocalDate?,
    var premiereDigital: LocalDate?,
    val premiereWorldCountry: String?,
    val premiereDvd: LocalDate?,
    val premiereBluRay: LocalDate?,
    var distributorRelease: String?,
    val countries: List<Country> = emptyList(),
    val genres: List<Genre> = emptyList(),
    val facts: List<String> = emptyList(),
    val seasons: List<Season> = emptyList()
)

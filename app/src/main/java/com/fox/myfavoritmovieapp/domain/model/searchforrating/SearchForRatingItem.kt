package com.fox.myfavoritmovieapp.domain.model.searchforrating

import com.fasterxml.jackson.annotation.JsonProperty
import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre
import com.fox.myfavoritmovieapp.domain.model.common.KinopoiskItemType
import com.google.gson.annotations.SerializedName

data class SearchForRatingItem(
//    @JsonProperty("filmId")
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("imdbId")
    var imdbId: String?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("nameEn")
    val nameEn: String?,
    @SerializedName("nameOriginal")
    val nameOriginal: String?,
    @SerializedName("countries")
    val countries: List<Country> = emptyList(),
    @SerializedName("genres")
    val genres: List<Genre> = emptyList(),
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: String?,
    @SerializedName("ratingImdb")
    val ratingImdb: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("type")
    val type: KinopoiskItemType? = KinopoiskItemType.UNKNOWN,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
)
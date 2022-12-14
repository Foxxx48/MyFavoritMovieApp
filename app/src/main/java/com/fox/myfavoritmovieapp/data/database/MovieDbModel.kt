package com.fox.myfavoritmovieapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre

@Entity(tableName = "movies")
data class MovieDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val year: String?,
    val filmLength: String?,
    val countries:  List<Country> = emptyList(),
    val genres: List<Genre> = emptyList(),
    val rating: String?, // can be percent if film has not been released
    val ratingVoteCount: Int?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val ratingChange: Int?,
    val isRatingUp: Int?,
    val isAfisha: Int
)

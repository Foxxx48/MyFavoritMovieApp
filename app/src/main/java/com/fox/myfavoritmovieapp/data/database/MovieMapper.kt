package com.fox.myfavoritmovieapp.data.database

import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

class MovieMapper {
    fun mapEntityToDbModel(topItem: TopItem): MovieDbModel {
        return MovieDbModel(
           id= topItem.id,
        kinopoiskId = topItem.kinopoiskId,
        nameRu = topItem.nameRu,
        nameEn = topItem.nameEn,
        year = topItem.year,
        filmLength = topItem.filmLength,
        countries = topItem.countries,
        genres = topItem.genres,
        rating = topItem.rating,
        ratingVoteCount = topItem.ratingVoteCount,
        posterUrl = topItem.posterUrl,
        posterUrlPreview = topItem.posterUrlPreview,
        ratingChange = topItem.ratingChange,
        isRatingUp = topItem.isRatingUp,
        isAfisha = topItem.isAfisha
        )
    }

    fun mapDbModelToEntity(movieDbModel: MovieDbModel): TopItem {
        return TopItem(
            id= movieDbModel.id,
            kinopoiskId = movieDbModel.kinopoiskId,
            nameRu = movieDbModel.nameRu,
            nameEn = movieDbModel.nameEn,
            year = movieDbModel.year,
            filmLength = movieDbModel.filmLength,
            countries = movieDbModel.countries,
            genres = movieDbModel.genres,
            rating = movieDbModel.rating,
            ratingVoteCount = movieDbModel.ratingVoteCount,
            posterUrl = movieDbModel.posterUrl,
            posterUrlPreview = movieDbModel.posterUrlPreview,
            ratingChange = movieDbModel.ratingChange,
            isRatingUp = movieDbModel.isRatingUp,
            isAfisha = movieDbModel.isAfisha
        )
    }

    fun mapListDbModelToListEntity(list: List<MovieDbModel>): List<TopItem> {
        return list.map {
            mapDbModelToEntity(it)
        }
    }

    fun mapListEntityToListDbModel(list: List<TopItem>): List<MovieDbModel> {
        return list.map {
            mapEntityToDbModel(it)
        }
    }
}
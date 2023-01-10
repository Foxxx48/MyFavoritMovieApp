package com.fox.myfavoritmovieapp.domain

import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

class DeleteMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(topItem: TopItem) = repository.deleteMovie(topItem)
}
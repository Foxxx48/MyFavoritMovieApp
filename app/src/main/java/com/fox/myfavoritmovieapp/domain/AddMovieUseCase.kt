package com.fox.myfavoritmovieapp.domain

import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

class AddMovieUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(topItem: TopItem) = movieRepository.addMovie(topItem)
}
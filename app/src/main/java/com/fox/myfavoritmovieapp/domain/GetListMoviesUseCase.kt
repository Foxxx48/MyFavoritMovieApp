package com.fox.myfavoritmovieapp.domain

class GetListMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getListMovies()
}
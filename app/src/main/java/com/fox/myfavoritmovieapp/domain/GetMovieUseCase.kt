package com.fox.myfavoritmovieapp.domain

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(movieId: Int) = movieRepository.getMovie(movieId)
}
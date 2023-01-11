package com.fox.myfavoritmovieapp.domain

class DeleteAllMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() = repository.deleteAllMovies()
}
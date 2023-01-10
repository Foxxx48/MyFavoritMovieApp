package com.fox.myfavoritmovieapp.presentation.dbactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fox.myfavoritmovieapp.data.database.repository.MovieRepositoryImpl
import com.fox.myfavoritmovieapp.domain.DeleteMovieUseCase
import com.fox.myfavoritmovieapp.domain.GetListMoviesUseCase
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem
import kotlinx.coroutines.launch

class MyDatabaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val getListMoviesUseCase = GetListMoviesUseCase(repository)
    private val deleteMovieUseCase = DeleteMovieUseCase(repository)

    val movieList = getListMoviesUseCase()

    fun deleteMovieItem(topItem: TopItem) {
        viewModelScope.launch {
            deleteMovieUseCase(topItem)
        }
    }
}
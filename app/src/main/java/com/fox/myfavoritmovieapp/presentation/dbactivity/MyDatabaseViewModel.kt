package com.fox.myfavoritmovieapp.presentation.dbactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fox.myfavoritmovieapp.data.database.repository.MovieRepositoryImpl
import com.fox.myfavoritmovieapp.domain.DeleteAllMoviesUseCase
import com.fox.myfavoritmovieapp.domain.DeleteMovieUseCase
import com.fox.myfavoritmovieapp.domain.GetListMoviesUseCase
import com.fox.myfavoritmovieapp.domain.GetMovieUseCase
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem
import kotlinx.coroutines.launch

class MyDatabaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val getListMoviesUseCase = GetListMoviesUseCase(repository)
    private val deleteMovieUseCase = DeleteMovieUseCase(repository)
    private val deleteAllMovieUseCase = DeleteAllMoviesUseCase(repository)
    private val getMovieUseCase = GetMovieUseCase(repository)

    private val _movieItem = MutableLiveData<TopItem>()
    val movieItem: LiveData<TopItem>
        get() = _movieItem

    val movieList = getListMoviesUseCase()

    fun deleteMovieItem(topItem: TopItem) {
        viewModelScope.launch {
            deleteMovieUseCase(topItem)
        }
    }

    fun deleteAllMovieItems() {
        viewModelScope.launch {
            deleteAllMovieUseCase()
        }
    }

    fun getMovieItem(movieId: Int) {
        viewModelScope.launch {
            val item= getMovieUseCase(movieId)
            _movieItem.value = item
        }
    }
}
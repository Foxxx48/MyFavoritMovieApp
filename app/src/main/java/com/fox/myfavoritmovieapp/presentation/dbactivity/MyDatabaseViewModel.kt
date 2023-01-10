package com.fox.myfavoritmovieapp.presentation.dbactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fox.myfavoritmovieapp.data.database.repository.MovieRepositoryImpl
import com.fox.myfavoritmovieapp.domain.GetListMoviesUseCase

class MyDatabaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val getListMoviesUseCase = GetListMoviesUseCase(repository)

    val movieList = getListMoviesUseCase()
}
package com.fox.myfavoritmovieapp.presentation.dbitemfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fox.myfavoritmovieapp.data.database.repository.MovieRepositoryImpl

class DbItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

}
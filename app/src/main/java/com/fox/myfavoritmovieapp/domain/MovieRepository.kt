package com.fox.myfavoritmovieapp.domain

import androidx.lifecycle.LiveData
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

interface MovieRepository {

    suspend fun addMovie(topItem: TopItem)

    suspend fun getMovie(movieId: Int): TopItem

    fun getListMovies(): LiveData<List<TopItem>>



}
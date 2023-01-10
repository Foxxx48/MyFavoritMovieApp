package com.fox.myfavoritmovieapp.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopType
import com.fox.myfavoritmovieapp.service.KinopoiskApiService
import com.fox.myfavoritmovieapp.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _films_rating = MutableLiveData<List<SearchForRatingItem>>()
    val films_rating: LiveData<List<SearchForRatingItem>>
        get() = _films_rating

    private val _films_popularity = MutableLiveData<List<TopItem>>()
    val films_popularity: LiveData<List<TopItem>>
        get() = _films_popularity


    fun getSearchForRatingItems(ratingFrom: Int, ratingTo: Int, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val kinopoiskApiService = KinopoiskApiService(NetworkUtils.API_KEY2, 10000)
            val data = kinopoiskApiService.getFilmsForRating(ratingFrom, ratingTo, page)
            var myFilms = data.getOrThrowException().items
            _films_rating.postValue(myFilms)
        }
    }

    fun getTopRatingItems(topType: TopType, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val kinopoiskApiService = KinopoiskApiService(NetworkUtils.API_KEY2, 10000)
            val data = kinopoiskApiService.getTop(topType, page)
            var myFilms = data.getOrThrowException().films
            _films_popularity.postValue(myFilms)
        }
    }

    companion object {
        var NUMBER_OF_PAGE = 1
    }
}
package com.fox.myfavoritmovieapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.myfavoritmovieapp.data.model.searchforrating.SearchForRatingItem
import com.fox.myfavoritmovieapp.service.KinopoiskApiService
import com.fox.myfavoritmovieapp.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _films = MutableLiveData<List<SearchForRatingItem>>()
    val films: LiveData<List<SearchForRatingItem>>
        get() = _films

    fun getSearchForRatingItems(){
        viewModelScope.launch(Dispatchers.IO) {
                val kinopoiskApiService = KinopoiskApiService(NetworkUtils.API_KEY2, 10000)
            val data = kinopoiskApiService.getFilmsForRating(8, 9, 1)
            var myFilms = data.getOrThrowException().items
            _films.postValue(myFilms)
        }
    }









}
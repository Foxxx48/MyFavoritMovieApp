package com.fox.myfavoritmovieapp.data

import com.fox.myfavoritmovieapp.data.models.Movie
import com.fox.myfavoritmovieapp.utils.NetworkUtils
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("${NetworkUtils.BASE_URL}?&token=${NetworkUtils.API_KEY}")
    suspend fun getListMovies(): Response<Movie>
}
package com.fox.myfavoritmovieapp.data

import com.fox.myfavoritmovieapp.data.models.Movie
import com.fox.myfavoritmovieapp.utils.NetworkUtils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("${NetworkUtils.BASE_URL_KP}?&token=${NetworkUtils.API_KEY}")
    suspend fun getListMovies(): Response<Movie>

//    @GET("${NetworkUtils.BASE_URL}?&token=${NetworkUtils.API_KEY}&search={id}&field=id")
//    suspend fun getMovieForId(@Path("id") id:Int): Response<Movie>

    @GET("${NetworkUtils.BASE_URL_KP}?&token=${NetworkUtils.API_KEY}")
    suspend fun getMovieFromKPForId(@Query("id") id:Int, @Query("field") field: String = "id"): Response<Movie>

//    kinopoisk.dev/movie?&token=Q4SDTKN-WAP4MNQ-MNMQY2Q-3Y00VNN&search=326&field=id
//    "${NetworkUtils.BASE_URL}?&token=${NetworkUtils.API_KEY}&search={id}&field=id"
}
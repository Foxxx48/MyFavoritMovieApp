package com.fox.myfavoritmovieapp.data

import com.fox.myfavoritmovieapp.utils.NetworkUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getMovieApi() : MovieApi {
        var retrofit = Retrofit.Builder()
            .baseUrl("http://example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var weatherApi : MovieApi = retrofit.create(MovieApi::class.java)
        return weatherApi
    }

//    private const val LINK = "https://api.openweathermap.org/data/2.5/"
//     const val API_TOKEN = "&appid=ea45d302d179b4dc2ae37bf6c2f5b5f7"

//    https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

//    "https://openweathermap.org/find?q=Moscow"

}
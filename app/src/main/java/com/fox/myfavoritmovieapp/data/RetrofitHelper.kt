package com.fox.myfavoritmovieapp.data

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    val READ_TIMEOUT = 100L
    val CONNECT_TIMEOUT = 100L

    fun getMovieApi() : MovieApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(0, 5, TimeUnit.MINUTES))


        var retrofit = Retrofit.Builder()
            .baseUrl("http://example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        var movieApi : MovieApi = retrofit.create(MovieApi::class.java)

        return movieApi
    }



//    private const val LINK = "https://api.openweathermap.org/data/2.5/"
//     const val API_TOKEN = "&appid=ea45d302d179b4dc2ae37bf6c2f5b5f7"

//    https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

//    "https://openweathermap.org/find?q=Moscow"

}
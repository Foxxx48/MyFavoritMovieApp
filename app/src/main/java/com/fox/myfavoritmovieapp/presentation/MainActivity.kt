package com.fox.myfavoritmovieapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.myfavoritmovieapp.data.RetrofitHelper
import com.fox.myfavoritmovieapp.data.model.MyResult
import com.fox.myfavoritmovieapp.data.model.movie.Common
import com.fox.myfavoritmovieapp.data.model.movie.Film
import com.fox.myfavoritmovieapp.databinding.ActivityMainBinding
import com.fox.myfavoritmovieapp.service.KinopoiskApiService
import com.fox.myfavoritmovieapp.utils.GlideApp

import com.fox.myfavoritmovieapp.utils.NetworkUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    var film : MyResult<Film>? = null
    var urlImage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        myLog(movie)

        val movieApi = RetrofitHelper.getMovieApi()

        CoroutineScope(Dispatchers.IO).launch {
//            val data = movieApi.getListMovies()
//            val data = movieApi.getMovieFromKPForId(326)
//            myLog(data)
            val kinopoiskApiService = KinopoiskApiService(NetworkUtils.API_KEY2, 10000)

            film = kinopoiskApiService.getFilm(399)
            urlImage = film?.getOrThrowException()?.data?.posterUrlPreview
            myLog(urlImage)
//            val image = film?.getOrThrowException()?.images?.posters?.get(0)
//            urlImage = image?.url
//            val resultFilms = kinopoiskApiService.getFilmsForRating(7,9,1)

//            val films = resultFilms.getOrThrowException().items
//            films.forEach {
//                myLog(it)
//            }



//            val topResult = kinopoiskApiService.getTop(TopType.TOP_250_BEST_FILMS, 1)
//            val topFilms = topResult.getOrThrowException().films
//            topFilms.forEach {
//                myLog(it)
//            }
        }

        binding.btnImage.setOnClickListener {
            getImage()
        }


//        myLog(NetworkUtils.buildURL(5))
//        val url = NetworkUtils.buildURL(5).toString()
//        myLog(url)
//
//        binding.btnDisplay.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                val connection = URL(url).openConnection() as HttpURLConnection
//                val data = connection.inputStream.bufferedReader().readText()
//
//                val intent = DisplayUrlActivity.newIntent(this@MainActivity, data)
//                startActivity(intent)
//            }
//        }


    }

    private fun getImage() {
        GlideApp.with(this)
            .load(urlImage)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .placeholder(R.drawable.ic_action_point)
            .into(binding.imageView)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    companion object {
        const val TAG = "myApp"

        fun myLog(message: Any?) {
            Log.d(TAG, "Main Activity: $message")
        }
    }
}
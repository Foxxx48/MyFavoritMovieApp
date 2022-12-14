package com.fox.myfavoritmovieapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.fox.myfavoritmovieapp.data.RetrofitHelper
import com.fox.myfavoritmovieapp.data.models.Movie
import com.fox.myfavoritmovieapp.databinding.ActivityMainBinding

import com.fox.myfavoritmovieapp.utils.NetworkUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    var movie = Movie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myLog(movie)

        val movieApi = RetrofitHelper.getMovieApi()

        CoroutineScope(Dispatchers.IO).launch {
//            val data = movieApi.getListMovies()
            val data = movieApi.getMovieFromKPForId(326)
            myLog(data)



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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun myLog(message: Any?) {
        Log.d(TAG, "Main Activity: $message")
    }

    companion object {
        const val TAG = "myApp"
    }
}
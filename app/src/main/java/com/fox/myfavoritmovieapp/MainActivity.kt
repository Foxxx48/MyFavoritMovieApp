package com.fox.myfavoritmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fox.myfavoritmovieapp.databinding.ActivityMainBinding
import com.fox.myfavoritmovieapp.utils.NetworkUtils

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLog(NetworkUtils.buildURL(5))
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
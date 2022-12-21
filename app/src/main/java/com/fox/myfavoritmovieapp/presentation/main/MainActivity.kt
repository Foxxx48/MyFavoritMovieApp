package com.fox.myfavoritmovieapp.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.fox.myfavoritmovieapp.databinding.ActivityMainBinding
import com.fox.myfavoritmovieapp.presentation.adapters.searchforratingitemadapter.SearchForRatingItemAdapter

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    private val viewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
    }

    private lateinit var searchForRatingItemAdapter: SearchForRatingItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSearchForRatingItems()

        setupRecyclerView()

        viewModel.films.observe(this) {
            searchForRatingItemAdapter.submitList(it)
        }


    }

    private fun setupRecyclerView() {
        searchForRatingItemAdapter = SearchForRatingItemAdapter()
//        binding.rvFilms.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        binding.rvFilms.layoutManager = GridLayoutManager(this, 2, HORIZONTAL, false)
        binding.rvFilms.adapter = searchForRatingItemAdapter

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


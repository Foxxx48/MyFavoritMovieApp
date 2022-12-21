package com.fox.myfavoritmovieapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    var ratingFrom = 5
    var ratingTo = 10

    private lateinit var searchForRatingItemAdapter: SearchForRatingItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSearchForRatingItems(ratingFrom, ratingTo, MainViewModel.PAGE_OF_RATING_ITEM)

        setupRecyclerView()

        viewModel.films.observe(this) {
            searchForRatingItemAdapter.submitList(it)
        }

        binding.btnNext.setOnClickListener {
            viewModel.getSearchForRatingItems(ratingFrom, ratingTo, ++ MainViewModel.PAGE_OF_RATING_ITEM)
        }

        binding.btnPrevious.setOnClickListener {
            if (MainViewModel.PAGE_OF_RATING_ITEM != 0) {
                viewModel.getSearchForRatingItems(ratingFrom, ratingTo, MainViewModel.PAGE_OF_RATING_ITEM --)
            } else {
                Toast.makeText(this, "It is first page", Toast.LENGTH_SHORT).show()
            }

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



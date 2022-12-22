package com.fox.myfavoritmovieapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.fox.myfavoritmovieapp.R
import com.fox.myfavoritmovieapp.data.model.top.movie.TopType
import com.fox.myfavoritmovieapp.databinding.ActivityMainBinding
import com.fox.myfavoritmovieapp.presentation.adapters.searchforratingitemadapter.SearchForRatingItemAdapter
import com.fox.myfavoritmovieapp.presentation.adapters.topitemadapter.TopItemAdapter

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    private val viewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
    }
    var ratingFrom = 5
    var ratingTo = 10

    private var searchForRatingItemAdapter = SearchForRatingItemAdapter()
    private var topItemAdapter = TopItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//       viewModel.getSearchForRatingItems(ratingFrom, ratingTo, MainViewModel.NUMBER_OF_PAGE)

        setMethodOfSort(binding.switchSort.isChecked)
        setupRecyclerView(topItemAdapter)
        viewModel.films_popularity.observe(this) {
            topItemAdapter.submitList(it)
        }

        binding.switchSort.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                setMethodOfSort(isChecked)
            } else {
                setMethodOfSort(isChecked)
            }
        }

        binding.tvMostPopular.setOnClickListener {
            setMethodOfSort(false)
            binding.switchSort.isChecked = false

        }

        binding.tvTopBest250.setOnClickListener {
            setMethodOfSort(true)
            binding.switchSort.isChecked = true


        }




        binding.btnNext.setOnClickListener {
            viewModel.getSearchForRatingItems(ratingFrom, ratingTo, ++MainViewModel.NUMBER_OF_PAGE)
        }

        binding.btnPrevious.setOnClickListener {
            if (MainViewModel.NUMBER_OF_PAGE != 0) {
                viewModel.getSearchForRatingItems(
                    ratingFrom,
                    ratingTo,
                    MainViewModel.NUMBER_OF_PAGE--
                )
            } else {
                Toast.makeText(this, "It is first page", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun setupRecyclerView(adapter: Any) {
        binding.rvFilms.layoutManager = GridLayoutManager(this, 2, HORIZONTAL, false)

//        binding.rvFilms.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        if (adapter.javaClass == TopItemAdapter::class.java) {
            binding.rvFilms.adapter = topItemAdapter

        } else {

            binding.rvFilms.adapter = searchForRatingItemAdapter
        }


    }

    fun setMethodOfSort(isPopRated: Boolean) {
        myLog("SetMethodOfSort: $isPopRated")
        val topType = if (isPopRated) {
            binding.tvMostPopular.setTextColor(resources.getColor(R.color.red, null))
            binding.tvTopBest250.setTextColor(resources.getColor(R.color.gray, null))
            TopType.TOP_100_POPULAR_FILMS
        } else {
            binding.tvMostPopular.setTextColor(resources.getColor(R.color.gray, null))
            binding.tvTopBest250.setTextColor(resources.getColor(R.color.red, null))
            TopType.TOP_250_BEST_FILMS
        }
        viewModel.getTopRatingItems(topType, MainViewModel.NUMBER_OF_PAGE)
        viewModel.films_popularity.observe(this) {
            topItemAdapter.submitList(it)
        }
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



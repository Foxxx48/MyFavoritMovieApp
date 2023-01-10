package com.fox.myfavoritmovieapp.presentation.dbactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.fox.myfavoritmovieapp.databinding.ActivityMyDatabaseBinding
import com.fox.myfavoritmovieapp.presentation.adapters.dbadapter.DbItemAdapter

class MyDatabaseActivity : AppCompatActivity() {

    private var _binding: ActivityMyDatabaseBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMyDatabaseBinding = null")

    private val myDbItemAdapter = DbItemAdapter()
    private lateinit var viewModel: MyDatabaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMyDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel = ViewModelProvider(this).get(MyDatabaseViewModel::class.java)
        viewModel.movieList.observe(this) {
            myDbItemAdapter.submitList(it)
        }
    }

    fun setupRecyclerView() {
        binding.rvDatabaseMovies.layoutManager = GridLayoutManager(this, 2, VERTICAL, false)
        binding.rvDatabaseMovies.adapter = myDbItemAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
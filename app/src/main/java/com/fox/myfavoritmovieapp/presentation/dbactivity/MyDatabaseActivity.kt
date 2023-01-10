package com.fox.myfavoritmovieapp.presentation.dbactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        setupSwipeListener(binding.rvDatabaseMovies)
    }

    private fun setupSwipeListener(rvPurchaseList: RecyclerView) {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = myDbItemAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteMovieItem(item)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvDatabaseMovies)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
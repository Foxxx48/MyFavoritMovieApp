package com.fox.myfavoritmovieapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fox.myfavoritmovieapp.data.model.top.movie.TopItem
import com.fox.myfavoritmovieapp.databinding.ActivityTopItemBinding

class TopItemActivity : AppCompatActivity() {
    private var _binding: ActivityTopItemBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("TopItemActivity = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTopItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topItem = intent.getParcelableExtra<TopItem>(TOP_ITEM)

        binding.textView.text = topItem?.nameRu
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        val TOP_ITEM = "top_item"

        fun newIntentTopItem(context: Context, topItem: TopItem ): Intent {
           val intent = Intent(context, TopItemActivity::class.java)
            intent.putExtra(TOP_ITEM, topItem)
            return intent
        }
    }


}
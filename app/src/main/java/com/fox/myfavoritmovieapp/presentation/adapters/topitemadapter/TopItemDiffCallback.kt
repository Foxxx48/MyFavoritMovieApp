package com.fox.myfavoritmovieapp.presentation.adapters.topitemadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

object TopItemDiffCallback : DiffUtil.ItemCallback<com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem>(){
    override fun areItemsTheSame(oldItem: com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem, newItem: com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem, newItem: com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem): Boolean {
        return oldItem == newItem
    }
}
package com.fox.myfavoritmovieapp.presentation.adapters.topitemadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.data.model.top.movie.TopItem

object TopItemDiffCallback : DiffUtil.ItemCallback<TopItem>(){
    override fun areItemsTheSame(oldItem: TopItem, newItem: TopItem): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: TopItem, newItem: TopItem): Boolean {
        return oldItem == newItem
    }
}
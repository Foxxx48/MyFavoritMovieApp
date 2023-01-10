package com.fox.myfavoritmovieapp.presentation.adapters.dbadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

object DbItemDiffCallback : DiffUtil.ItemCallback<TopItem>(){
    override fun areItemsTheSame(oldItem: TopItem, newItem: TopItem): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: TopItem, newItem: TopItem): Boolean {
        return oldItem == newItem
    }
}
package com.fox.myfavoritmovieapp.presentation.adapters.searchforratingitemadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.data.model.searchforrating.SearchForRatingItem


object  SearchForRatingItemDiffCallback: DiffUtil.ItemCallback<SearchForRatingItem>(){
    override fun areItemsTheSame(oldItem: SearchForRatingItem, newItem: SearchForRatingItem): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: SearchForRatingItem, newItem: SearchForRatingItem): Boolean {
        return oldItem == newItem
    }

}
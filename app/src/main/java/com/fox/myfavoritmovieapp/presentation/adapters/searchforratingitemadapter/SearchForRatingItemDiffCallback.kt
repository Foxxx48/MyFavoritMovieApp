package com.fox.myfavoritmovieapp.presentation.adapters.searchforratingitemadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem


object  SearchForRatingItemDiffCallback: DiffUtil.ItemCallback<com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem>(){
    override fun areItemsTheSame(oldItem: com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem, newItem: com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem, newItem: com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem): Boolean {
        return oldItem == newItem
    }

}
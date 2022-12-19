package com.fox.myfavoritmovieapp.presentation.adapters.filmadapter

import androidx.recyclerview.widget.DiffUtil
import com.fox.myfavoritmovieapp.data.model.movie.Film

object  FilmDiffCallback: DiffUtil.ItemCallback<Film>(){
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.externalId == newItem.externalId
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }

}
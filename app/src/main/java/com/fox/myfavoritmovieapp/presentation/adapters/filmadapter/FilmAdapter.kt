package com.fox.myfavoritmovieapp.presentation.adapters.filmadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.fox.myfavoritmovieapp.data.model.movie.Film
import com.fox.myfavoritmovieapp.databinding.FilmItemBinding

class FilmAdapter : ListAdapter<Film, FilmViewHolder>(FilmDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = FilmItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
package com.fox.myfavoritmovieapp.presentation.adapters.searchforratingitemadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem

import com.fox.myfavoritmovieapp.databinding.FilmItemBinding
import com.fox.myfavoritmovieapp.presentation.main.MainActivity
import com.fox.myfavoritmovieapp.utils.GlideApp

class SearchForRatingItemAdapter() : ListAdapter<com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem, SearchForRatingItemViewHolder>(SearchForRatingItemDiffCallback) {

    var onFilmItemLongClickListener: ((com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem) -> Unit)? = null
    var onFilmItemClickListener: ((com.fox.myfavoritmovieapp.domain.model.searchforrating.SearchForRatingItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchForRatingItemViewHolder {
        val binding = FilmItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchForRatingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchForRatingItemViewHolder, position: Int) {
        val filmItem = getItem(position)

        holder.binding.root.setOnClickListener {
            onFilmItemClickListener?.invoke(filmItem)
        }

        holder.binding.root.setOnLongClickListener {
            onFilmItemLongClickListener?.invoke(filmItem)
            return@setOnLongClickListener true
        }

        holder.binding.tvFilmName.text = filmItem.nameRu

        val genre = filmItem.genres.toString().replace("[", "").replace("]", "")
        holder.binding.tvGenre.text = genre

        holder.binding.tvRating.text = filmItem.ratingKinopoisk

        val urlImage = filmItem.posterUrlPreview
        MainActivity.myLog(urlImage)
        GlideApp.with(holder.itemView.context)
            .load(urlImage)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .placeholder(R.drawable.ic_action_point)
            .into(holder.binding.ivPosterPreview)

    }


}
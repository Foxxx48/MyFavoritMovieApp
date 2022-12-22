package com.fox.myfavoritmovieapp.presentation.adapters.topitemadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.myfavoritmovieapp.data.model.top.movie.TopItem
import com.fox.myfavoritmovieapp.databinding.FilmItemBinding
import com.fox.myfavoritmovieapp.presentation.main.MainActivity
import com.fox.myfavoritmovieapp.utils.GlideApp

class TopItemAdapter : ListAdapter<TopItem, TopItemViewHolder>(
    TopItemDiffCallback
) {
    var onTopItemLongClickListener: ((TopItem) -> Unit)? = null
    var onTopItemClickListener: ((TopItem) -> Unit)? = null
    var onReachEndListener: ((TopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopItemViewHolder {
        val binding = FilmItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TopItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopItemViewHolder, position: Int) {
        val filmItem = getItem(position)

        if (position > currentList.size  - 2) {
            onReachEndListener?.invoke(filmItem)
        }


        holder.binding.root.setOnClickListener {
            onTopItemClickListener?.invoke(filmItem)
        }

        holder.binding.root.setOnLongClickListener {
            onTopItemLongClickListener?.invoke(filmItem)
            return@setOnLongClickListener true
        }

        with(holder.binding) {
            tvGenre.text = filmItem.genres
                .toString().replace("[", "").replace("]", "")

            tvFilmName.text = filmItem.nameRu

            tvRating.text = filmItem.rating
        }

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
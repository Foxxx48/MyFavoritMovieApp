package com.fox.myfavoritmovieapp.presentation.adapters.dbadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem
import com.fox.myfavoritmovieapp.databinding.FilmItemBinding
import com.fox.myfavoritmovieapp.presentation.main.MainActivity
import com.fox.myfavoritmovieapp.utils.GlideApp

class DbItemAdapter : ListAdapter<TopItem, DbItemViewHolder>(
    DbItemDiffCallback
) {
    var onDbItemLongClickListener: ((TopItem) -> Unit)? = null
    var onDbItemClickListener: ((TopItem) -> Unit)? = null
    var onReachEndListener: ((TopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DbItemViewHolder {
        val binding = FilmItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DbItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DbItemViewHolder, position: Int) {
        val filmItem = getItem(position)

        if (position > currentList.size  - 2) {
            onReachEndListener?.invoke(filmItem)
        }


        holder.binding.root.setOnClickListener {
            onDbItemClickListener?.invoke(filmItem)
        }

        holder.binding.root.setOnLongClickListener {
            onDbItemLongClickListener?.invoke(filmItem)
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
package com.fox.myfavoritmovieapp.data.model.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(val id: Int, val genre: String) : Parcelable {
    override fun toString(): String {
        return genre
    }
}

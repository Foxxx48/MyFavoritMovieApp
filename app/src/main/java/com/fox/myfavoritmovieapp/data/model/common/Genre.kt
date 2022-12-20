package com.fox.myfavoritmovieapp.data.model.common

data class Genre(val id: Int, val genre: String) {
    override fun toString(): String {
        return genre
    }
}

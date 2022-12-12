package com.fox.myfavoritmovieapp.utils

import com.fox.myfavoritmovieapp.data.models.Movie
import org.json.JSONException
import org.json.JSONObject


class JsonUtils {
    private val KEY_DOCS = "docs"
    private val KEY_VOTE_COUNT = "vote_count"
    private val KEY_ID = "id"
    private val KEY_TITLE = "title"
    private val KEY_ORIGINAL_TITLE = "original_title"
    private val KEY_OVERVIEW = "overview"
    private val KEY_POSTER_PATH = "poster_path"
    private val KEY_BACKDROP_PATH = "backdrop_path"
    private val KEY_VOTE_AVERAGE = "vote_average"
    private val KEY_RELEASE_DATE = "release_date"

    fun getMoviesFromJSON(jsonObject: JSONObject?): ArrayList<Movie?>? {
        val result: ArrayList<Movie?> = ArrayList()
        if (jsonObject == null) {
            return result
        }
        try {
            val jsonArray = jsonObject.getJSONArray(KEY_DOCS)
            for (i in 0 until jsonArray.length()) {
                val objectMovie = jsonArray.getJSONObject(i)
                val id = objectMovie.getInt(KEY_ID)
                val voteCount = objectMovie.getInt(KEY_VOTE_COUNT)
                val title = objectMovie.getString(KEY_TITLE)
                val originalTitle = objectMovie.getString(KEY_ORIGINAL_TITLE)
                val overview = objectMovie.getString(KEY_OVERVIEW)
                val posterPath = objectMovie.getString(KEY_POSTER_PATH)
                val backdropPath = objectMovie.getString(KEY_BACKDROP_PATH)
                val voteAverage = objectMovie.getDouble(KEY_VOTE_AVERAGE)
                val releaseDate = objectMovie.getString(KEY_RELEASE_DATE)
                val movie = Movie()
                result.add(movie)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}
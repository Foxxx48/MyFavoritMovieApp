package com.fox.myfavoritmovieapp.utils

import android.provider.VoicemailContract.Status
import com.fox.myfavoritmovieapp.data.models.Movie
import org.json.JSONException
import org.json.JSONObject
import java.net.IDN


class JsonUtils {
    private val KEY_DOCS = "docs"
    private val KEY_EXTERNAL_ID ="externalId"
    private val KEY_POSTER ="poster"
    private val KEY_RATING ="rating"
    private val KEY_BACKGROUND ="backdrop"
    private val KEY_VOTES ="votes"
    private val KEY_FEELS ="fees"
    private val KEY_DESTRIBUTORS ="distributors"
    private val KEY_PREMIERE ="premiere"
    private val KEY_IMAGES ="images"
    private val KEY_WATCHABILITY ="watchability"
    private val KEY_COLLECTIONS ="collections"
    private val KEY_UPDATE_DATES ="updateDates"
    private val KEY_STATUS ="status"
    private val KEY_MOVIE_LENGTH = "movieLength"
    private val KEY_PRODUCTION_COMPANIES ="productionCompanies"
    private val KEY_SPOKEN_LANGUAGES ="spokenLanguages"
    private val KEY_ID ="id"
    private val KEY_TYPE ="type"
    private val KEY_NAME ="name"
    private val KEY_DESCRIPTION ="description"
    private val KEY_SLOGAN ="slogan"
    private val KEY_YEAR ="year"
    private val KEY_FACTS ="facts"
    private val KEY_GENRES ="genres"
    private val KEY_COUNTRIES ="countries"
    private val KEY_SEASON_INFO ="seasonsInfo"
    private val KEY_PERSONS ="persons"
    private val KEY_LISTS ="lists"
    private val KEY_TYPE_NUMBER ="typeNumber"
    private val KEY_ALTERNATIVE_NAME ="alternativeName"
    private val KEY_EN_NAME ="enName"
    private val KEY_NAMES ="names"
    private val KEY_UPDATED_AT ="updatedAt"
    private val KEY_RATING_MPAA ="ratingMpaa"
    private val KEY_SHORT_DESCRIPTION ="shortDescription"
    private val KEY_TECHNOLOGY ="technology"
    private val KEY_TICKETS_ON_SALE ="ticketsOnSale"
    private val KEY_SEQUELS_AND_PREQUELS ="sequelsAndPrequels"
    private val KEY_SIMILAR_MOVIES ="similarMovies"
    private val KEY_IMAGES_INFO ="imagesInfo"
    private val KEY_AGE_RATNG ="ageRating"
    private val KEY_TOP_10 ="top10"
    private val KEY_TOP_250 ="top250"
    private val KEY_CREATE_DATE ="createDate"
    private val KEY_RELEASE_YEARS ="releaseYears"


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
                val name = objectMovie.getString(KEY_NAME)
                val engName = objectMovie.getString(KEY_EN_NAME)
                val genres = objectMovie.getString(KEY_GENRES)
                val poster = objectMovie.getString(KEY_POSTER)
                val backdropPath = objectMovie.getString(KEY_BACKDROP_PATH)
                val voteAverage = objectMovie.getDouble(KEY_VOTE_AVERAGE)
                val releaseDate = objectMovie.getString(KEY_RELEASE_DATE)
                val votes = objectMovie.getInt(KEY_VOTES)
                val movie = Movie()
                result.add(movie)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}
package com.fox.myfavoritmovieapp.utils

import com.fox.myfavoritmovieapp.data.models.*
import org.json.JSONException
import org.json.JSONObject


class JsonUtils {
    private val KEY_DOCS = "docs"
    private val KEY_EXTERNAL_ID = "externalId"
    private val KEY_LOGO = "logo"
    private val KEY_POSTER = "poster"
    private val KEY_RATING = "rating"
    private val KEY_BACKDROP = "backdrop"
    private val KEY_VOTES = "votes"
    private val KEY_VIDEOS = "videos"
    private val KEY_BUDGET = "budget"
    private val KEY_FEELS = "fees"
    private val KEY_DESTRIBUTORS = "distributors"
    private val KEY_PREMIERE = "premiere"
    private val KEY_IMAGES = "images"
    private val KEY_WATCHABILITY = "watchability"
    private val KEY_COLLECTIONS = "collections"
    private val KEY_UPDATE_DATES = "updateDates"
    private val KEY_STATUS = "status"
    private val KEY_MOVIE_LENGTH = "movieLength"
    private val KEY_PRODUCTION_COMPANIES = "productionCompanies"
    private val KEY_SPOKEN_LANGUAGES = "spokenLanguages"
    private val KEY_ID = "id"
    private val KEY_TYPE = "type"
    private val KEY_NAME = "name"
    private val KEY_DESCRIPTION = "description"
    private val KEY_SLOGAN = "slogan"
    private val KEY_YEAR = "year"
    private val KEY_FACTS = "facts"
    private val KEY_GENRES = "genres"
    private val KEY_COUNTRIES = "countries"
    private val KEY_SEASON_INFO = "seasonsInfo"
    private val KEY_PERSONS = "persons"
    private val KEY_LISTS = "lists"
    private val KEY_TYPE_NUMBER = "typeNumber"
    private val KEY_ALTERNATIVE_NAME = "alternativeName"
    private val KEY_EN_NAME = "enName"
    private val KEY_NAMES = "names"
    private val KEY_UPDATED_AT = "updatedAt"
    private val KEY_RATING_MPAA = "ratingMpaa"
    private val KEY_SHORT_DESCRIPTION = "shortDescription"
    private val KEY_TECHNOLOGY = "technology"
    private val KEY_TICKETS_ON_SALE = "ticketsOnSale"
    private val KEY_SEQUELS_AND_PREQUELS = "sequelsAndPrequels"
    private val KEY_SIMILAR_MOVIES = "similarMovies"
    private val KEY_IMAGES_INFO = "imagesInfo"
    private val KEY_AGE_RATNG = "ageRating"
    private val KEY_TOP_10 = "top10"
    private val KEY_TOP_250 = "top250"
    private val KEY_CREATE_DATE = "createDate"
    private val KEY_RELEASE_YEARS = "releaseYears"


    fun getMoviesFromJSON(jsonObject: JSONObject?): ArrayList<Movie?>? {
        val result: ArrayList<Movie?> = ArrayList()
        if (jsonObject == null) {
            return result
        }
        try {
            val jsonArray = jsonObject.getJSONArray(KEY_DOCS)
            for (i in 0 until jsonArray.length()) {
                val objectMovie = jsonArray.getJSONObject(i)

                val externalId = objectMovie.getJSONObject(KEY_EXTERNAL_ID) as ExternalId
                val logo = objectMovie.getJSONObject(KEY_LOGO) as Logo
                val poster = objectMovie.getJSONObject(KEY_POSTER) as Poster
                val rating = objectMovie.getJSONObject(KEY_RATING) as Rating
                val backdrop = objectMovie.getJSONObject(KEY_BACKDROP) as Backdrop
                val votes = objectMovie.getJSONObject(KEY_VOTES) as Votes
                val videos = objectMovie.getJSONObject(KEY_VIDEOS) as Videos
                val budget = objectMovie.getJSONObject(KEY_BUDGET) as Budget
                val fees = objectMovie.getJSONObject(KEY_FEELS)as Fees
                val distributors = objectMovie.getJSONObject(KEY_DESTRIBUTORS) as Distributors
                val premiere = objectMovie.getJSONObject(KEY_PREMIERE) as Premiere
                val images = objectMovie.getJSONObject(KEY_IMAGES) as Images
                val watchability = objectMovie.getJSONObject(KEY_WATCHABILITY) as Watchability
                val collections = objectMovie.getJSONArray(KEY_COLLECTIONS) as ArrayList<String>
                val updateDates = objectMovie.getJSONArray(KEY_UPDATE_DATES) as ArrayList<String>
                val status = objectMovie.getString(KEY_STATUS)
                val movieLength = objectMovie.getInt(KEY_MOVIE_LENGTH)
                val productionCompanies = objectMovie.getJSONArray(KEY_PRODUCTION_COMPANIES) as ArrayList<ProductionCompanies>
                val spokenLanguages = objectMovie.getJSONArray(KEY_SPOKEN_LANGUAGES) as ArrayList<SpokenLanguages>
                val id = objectMovie.getInt(KEY_ID)
                val type = objectMovie.getString(KEY_TYPE)
                val name = objectMovie.getString(KEY_NAME)
                val description = objectMovie.getString(KEY_DESCRIPTION)
                val slogan = objectMovie.getString(KEY_SLOGAN)
                val year = objectMovie.getInt(KEY_YEAR)
                val facts = objectMovie.getJSONArray(KEY_FACTS) as ArrayList<Facts>
                val genres = objectMovie.getJSONArray(KEY_GENRES) as ArrayList<Genres>
                val countries = objectMovie.getJSONArray(KEY_COUNTRIES) as ArrayList<Countries>
                val seasonsInfo = objectMovie.getJSONArray(KEY_SEASON_INFO) as ArrayList<String>
                val persons = objectMovie.getJSONArray(KEY_PERSONS) as ArrayList<Persons>
                val lists = objectMovie.getJSONArray(KEY_LISTS) as ArrayList<String>
                val typeNumber = objectMovie.getInt(KEY_TYPE_NUMBER)
                val alternativeName = objectMovie.getString(KEY_ALTERNATIVE_NAME)
                val enName = objectMovie.getString(KEY_EN_NAME)
                val names = objectMovie.getJSONArray(KEY_NAMES) as ArrayList<Names>
                val updatedAt = objectMovie.getString(KEY_UPDATED_AT)
                val ratingMpaa = objectMovie.getString(KEY_RATING_MPAA)
                val shortDescription = objectMovie.getString(KEY_SHORT_DESCRIPTION)
                val technology = objectMovie.getJSONObject(KEY_TECHNOLOGY) as Technology
                val ticketsOnSale = objectMovie.getBoolean(KEY_TICKETS_ON_SALE)
                val sequelsAndPrequels = objectMovie.getJSONArray(KEY_SEQUELS_AND_PREQUELS) as ArrayList<SequelsAndPrequels>
                val similarMovies = objectMovie.getJSONArray(KEY_SIMILAR_MOVIES) as ArrayList<String>
                val imagesInfo = objectMovie.getJSONObject(KEY_IMAGES_INFO) as ImagesInfo
                val ageRating = objectMovie.getInt(KEY_AGE_RATNG)
                val top10 = objectMovie.getString(KEY_TOP_10)
                val top250 = objectMovie.getInt(KEY_TOP_250)
                val createDate = objectMovie.getString(KEY_CREATE_DATE)
                val releaseYears = objectMovie.getJSONArray(KEY_RELEASE_YEARS) as ArrayList<String>


                val movie = Movie(
                    externalId = externalId,
                    logo= logo,
                    poster = poster,
                    rating = rating,
                    backdrop = backdrop,
                    votes = votes,
                    videos= videos,
                    budget = budget,
                    fees = fees,
                    distributors = distributors,
                    premiere = premiere,
                    images = images,
                    watchability = watchability,
                    collections = collections,
                    updateDates = updateDates,
                    status = status,
                    movieLength = movieLength,
                    productionCompanies = productionCompanies,
                    spokenLanguages = spokenLanguages,
                    id = id,
                    type = type,
                    name = name,
                    description = description,
                    slogan = slogan,
                    year = year,
                    facts = facts,
                    genres = genres,
                    countries = countries,
                    seasonsInfo = seasonsInfo,
                    persons = persons,
                    lists = lists,
                    typeNumber = typeNumber,
                    alternativeName = alternativeName,
                    enName = enName,
                    names = names,
                    updatedAt = updatedAt,
                    ratingMpaa = ratingMpaa,
                    shortDescription = shortDescription,
                    technology = technology,
                    ticketsOnSale = ticketsOnSale,
                    sequelsAndPrequels = sequelsAndPrequels,
                    similarMovies = similarMovies,
                    imagesInfo = imagesInfo,
                    ageRating = ageRating,
                    top10 = top10,
                    top250 = top250,
                    createDate = createDate,
                    releaseYears = releaseYears
                )
                result.add(movie)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}
package com.fox.myfavoritmovieapp.data.database

import androidx.room.TypeConverter
import com.fox.myfavoritmovieapp.domain.model.common.Country
import com.fox.myfavoritmovieapp.domain.model.common.Genre
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listGenreToJsonString(value: List<Genre>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToListGenre(value: String) = Gson().fromJson(value, Array<Genre>::class.java).toList()

    @TypeConverter
    fun listCountryToJsonString(value: List<Country>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToListCountry(value: String) = Gson().fromJson(value, Array<Country>::class.java).toList()


}
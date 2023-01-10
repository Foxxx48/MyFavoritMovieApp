package com.fox.myfavoritmovieapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies" )
    fun getMoviesList(): LiveData<List<MovieDbModel>>

    @Insert(entity = MovieDbModel::class, onConflict = REPLACE)
    suspend fun addMovie(movieDbModel: MovieDbModel)

    @Query("DELETE FROM movies WHERE id=:movieId")
    suspend fun deleteMovie(movieId: Int)

    @Query("SELECT * FROM movies WHERE id=:movieId LIMIT 1")
    suspend fun getMovie(movieId: Int): MovieDbModel

    @Update(onConflict = REPLACE)
    suspend fun updateMovie(movieDbModel: MovieDbModel)
}
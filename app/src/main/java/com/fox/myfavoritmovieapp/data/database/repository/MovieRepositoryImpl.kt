package com.fox.myfavoritmovieapp.data.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.fox.myfavoritmovieapp.data.database.MovieDao
import com.fox.myfavoritmovieapp.data.database.MovieDatabase
import com.fox.myfavoritmovieapp.data.database.MovieMapper
import com.fox.myfavoritmovieapp.domain.MovieRepository
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem

class MovieRepositoryImpl(application: Application) : MovieRepository {
    private val movieDao = MovieDatabase.getInstance(application).movieDao()
    private val movieMapper = MovieMapper()

    override suspend fun addMovie(topItem: TopItem) {
        movieDao.addMovie(movieMapper.mapEntityToDbModel(topItem))
    }

    override suspend fun getMovie(movieId: Int): TopItem {
        val movie = movieDao.getMovie(movieId)
        return movieMapper.mapDbModelToEntity(movie)
    }

    override fun getListMovies(): LiveData<List<TopItem>> = Transformations.map(
        movieDao.getMoviesList()
    ) {
        movieMapper.mapListDbModelToListEntity(it)
    }
}
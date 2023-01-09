package com.fox.myfavoritmovieapp.data.database

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "movies.db"

        fun getInstance(application: Application): MovieDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    MovieDatabase::class.java,
                    DB_NAME

                ).build()

                INSTANCE = db
                return db
            }
        }
    }
}
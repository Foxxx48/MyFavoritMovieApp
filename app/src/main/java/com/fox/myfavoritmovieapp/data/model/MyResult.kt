package com.fox.myfavoritmovieapp.data.model

sealed class MyResult<T> {
    abstract fun getOrThrowException(): T
    abstract fun getOrNull(): T?

    data class Success<T>(val httpStatus: Int, val result: T) : MyResult<T>() {
        override fun getOrThrowException(): T = result
        override fun getOrNull(): T = result
    }

    data class Failure<T>(val httpStatus: Int, val error: String) : MyResult<T>() {
        override fun getOrThrowException(): T = throw UnsupportedOperationException()
        override fun getOrNull(): T? = null
    }
}

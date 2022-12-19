package com.fox.myfavoritmovieapp.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fox.myfavoritmovieapp.data.model.MyResult
import com.fox.myfavoritmovieapp.presentation.MainActivity
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost


internal class KPApiClientService(private val token: String, private val timeout: Int) {
    private val mapper: ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())

    companion object {
        const val AUTH_HEADER = "X-API-KEY"
        const val MAIN_API_URL_V1 = "https://kinopoiskapiunofficial.tech/api/v1"
        const val MAIN_API_URL_V2_1 = "https://kinopoiskapiunofficial.tech/api/v2.1"
        const val MAIN_API_URL_V2_2 = "https://kinopoiskapiunofficial.tech/api/v2.2"

        const val GET_FILM = "/films"
        const val GET_FRAMES = "/frames"
        const val GET_VIDEOS = "/videos"
        const val GET_STUDIOS = "/studios"
        const val GET_SEQUELS_AND_PREQUELS = "/sequels_and_prequels"
        const val GET_TOP = "/top"
        const val GET_STAFF = "/staff"

        const val SEARCH_BY_KEYWORD = "/search-by-keyword"
    }

    fun <T> request(url: String, path: String, clazz: Class<T>): MyResult<T> {
        val (request, response, result) = (url + path)
            .httpGet()
            .timeout(timeout)
            .timeoutRead(timeout)
            .header(mapOf(AUTH_HEADER to token))
            .responseString()


        MainActivity.myLog("Request:$request")
        MainActivity.myLog("Response:$response")
        MainActivity.myLog("Result:$result")
        MainActivity.myLog("Url:$url")
        MainActivity.myLog("Path:$path")

        return when (result) {
            is com.github.kittinunf.result.Result.Failure -> MyResult.Failure(
                httpStatus = response.statusCode,
                error = response.responseMessage
            )
            is com.github.kittinunf.result.Result.Success -> MyResult.Success(
                httpStatus = response.statusCode,
                result = mapper.readValue(result.get(), clazz)
            )
        }

    }
}
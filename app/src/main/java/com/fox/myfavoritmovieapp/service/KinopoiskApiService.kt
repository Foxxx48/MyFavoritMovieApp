package com.fox.myfavoritmovieapp.service

import com.fox.myfavoritmovieapp.data.model.MyResult
import com.fox.myfavoritmovieapp.data.model.movie.AppendType
import com.fox.myfavoritmovieapp.data.model.movie.Film
import com.fox.myfavoritmovieapp.data.model.movie.frames.GalleryResult
import com.fox.myfavoritmovieapp.data.model.movie.related.RelatedFilmItem
import com.fox.myfavoritmovieapp.data.model.movie.studio.StudioResult
import com.fox.myfavoritmovieapp.data.model.movie.video.VideoResult
import com.fox.myfavoritmovieapp.data.model.search.movie.keyword.SearchResult
import com.fox.myfavoritmovieapp.data.model.searchforrating.SearchForRatingResult
import com.fox.myfavoritmovieapp.data.model.staff.Person
import com.fox.myfavoritmovieapp.data.model.staff.StaffItem
import com.fox.myfavoritmovieapp.data.model.top.movie.TopResult
import com.fox.myfavoritmovieapp.data.model.top.movie.TopType
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_FILM
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_FRAMES
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_SEQUELS_AND_PREQUELS
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_STAFF
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_STUDIOS
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_TOP
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.GET_VIDEOS
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.MAIN_API_URL_V1
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.MAIN_API_URL_V2_1
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.MAIN_API_URL_V2_2
import com.fox.myfavoritmovieapp.service.KPApiClientService.Companion.SEARCH_BY_KEYWORD

class KinopoiskApiService(token: String, timeoutMs: Int = 15000) {
    private val kpApiClientService: KPApiClientService = KPApiClientService(token, timeoutMs)

    /**
     * This method retrieves film data.
     *
     * @param kinopoiskId id of film from kinopoisk.
     * @param appendTypes to add additional info to response. See [AppendType].
     */
    fun getFilm(kinopoiskId: Int, appendTypes: Iterable<AppendType> = emptyList()): MyResult<Film> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        val appends = appendTypes.joinToString()
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId?append_to_response=$appends",
            Film::class.java
        )

    }

    /**
     * Returns frames for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getFrames(kinopoiskId: Int): MyResult<GalleryResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_FRAMES",
            GalleryResult::class.java
        )
    }

    /**
     * Returns videos for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getVideos(kinopoiskId: Int): MyResult<VideoResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_VIDEOS",
            VideoResult::class.java
        )
    }

    /**
     * Returns studios for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getStudios(kinopoiskId: Int): MyResult<StudioResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_STUDIOS",
            StudioResult::class.java
        )
    }

    /**
     * Returns sequels and prequels for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getSequelsAndPrequels(kinopoiskId: Int): MyResult<List<RelatedFilmItem>> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_SEQUELS_AND_PREQUELS",
            List::class.java as Class<List<RelatedFilmItem>>
        )
    }

    /**
     * Returns search result by keyword.
     *
     * @param keyword keyword to search.
     * @param page page.
     */
    fun searchByKeyword(keyword: String, page: Int = 1): MyResult<SearchResult> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM$SEARCH_BY_KEYWORD?keyword=$keyword&page=$page",
            SearchResult::class.java
        )
    }

    /**
     * Returns top by particular top type [TopType].
     *
     * @param topType see [TopType].
     * @param page page.
     */
    fun getTop(topType: TopType, page: Int = 1): MyResult<TopResult> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_2,
            "$GET_FILM$GET_TOP?type=$topType&page=$page",
            TopResult::class.java
        )
    }

    /**
     * Returns all persons by particular film id.
     *
     * @param kinopoiskFilmId film id.
     */
    fun getStaff(kinopoiskFilmId: Int): MyResult<List<StaffItem>> {
        return kpApiClientService.request(
            MAIN_API_URL_V1,
            "$GET_STAFF?filmId=$kinopoiskFilmId",
            List::class.java as Class<List<StaffItem>>
        )
    }

    /**
     * Returns person by particular film..
     *
     * @param kinopoiskId person id.
     */
    fun getPerson(kinopoiskId: Int): MyResult<Person> {
        return kpApiClientService.request(
            MAIN_API_URL_V1,
            "$GET_STAFF/$kinopoiskId",
            Person::class.java
        )
    }

    fun getFilmsForRating(ratingFrom: Int, ratingTo: Int, page: Int): MyResult<SearchForRatingResult> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_2,
            "$GET_FILM?order=RATING&type=ALL&ratingFrom=$ratingFrom&ratingTo=$ratingTo&yearFrom=1000&yearTo=3000&page=$page",
            SearchForRatingResult::class.java
        )
    }
}
//kinopoiskapiunofficial.tech/api/v2.2/films?order=RATING&type=ALL&ratingFrom=8&ratingTo=10&yearFrom=1000&yearTo=3000&page=1
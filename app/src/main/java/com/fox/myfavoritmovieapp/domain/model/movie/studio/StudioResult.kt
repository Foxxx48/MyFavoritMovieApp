package com.fox.myfavoritmovieapp.domain.model.movie.studio

data class StudioResult(
    val production: String?,
    val filming: String?,
    val imageFormat: String?,
    val camera: String?,
    val copyFormat: String?,
    val filmingFormat: String?,
    val image: String?,
    val language: String?,
    val productionStudios: List<com.fox.myfavoritmovieapp.domain.model.movie.studio.StudioItem> = emptyList(),
    val specialEffectsStudios: List<com.fox.myfavoritmovieapp.domain.model.movie.studio.StudioItem> = emptyList(),
    val dubbingStudios: List<com.fox.myfavoritmovieapp.domain.model.movie.studio.StudioItem> = emptyList(),
    val rentStudios: List<com.fox.myfavoritmovieapp.domain.model.movie.studio.StudioItem> = emptyList()
)

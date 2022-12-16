package com.fox.myfavoritmovieapp.data.model.movie

data class Film(
    var data: Common,
    var externalId: ExternalId?,
    var rating: Rating?,
    var budget: Budget?,
    var review: Review?,
    var images: Poster?
)

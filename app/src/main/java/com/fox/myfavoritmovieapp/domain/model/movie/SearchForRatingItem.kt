package com.fox.myfavoritmovieapp.domain.model.movie

data class SearchForRatingItem(
    var data: Common,
    var externalId: ExternalId?,
    var rating: Rating?,
    var budget: Budget?,
    var review: Review?,
    var images: Poster?
)

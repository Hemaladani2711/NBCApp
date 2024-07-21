package com.hemaladani.nbcapp.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Root (
    var page: String? = null,
    var shelves: List<Shelf>? = null
)

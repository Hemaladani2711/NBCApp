package com.hemaladani.nbcapp.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Shelf (
    var title: String? = null,
    var type: String? = null,
    var items: List<Item>? = null
)

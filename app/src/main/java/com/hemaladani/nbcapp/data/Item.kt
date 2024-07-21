package com.hemaladani.nbcapp.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item (
    var type: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var subtitle: String? = null,
    var image: String? = null,
    var labelBadge: String? = null,
)

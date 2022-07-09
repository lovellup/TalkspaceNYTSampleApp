package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Headline(
    @Json(name = "main") var main: String? = null,
    @Json(name = "kicker") var kicker: String? = null,
    @Json(name = "content_kicker") var contentKicker: String? = null,
    @Json(name = "print_headline") var printHeadline: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "seo") var seo: String? = null,
    @Json(name = "sub") var sub: String? = null
)
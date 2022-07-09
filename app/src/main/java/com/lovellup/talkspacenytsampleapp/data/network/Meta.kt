package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json


data class Meta(
    @Json(name = "hits") var hits: Int? = null,
    @Json(name = "offset") var offset: Int? = null,
    @Json(name = "time") var time: Int? = null
)
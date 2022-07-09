package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Response(
    @Json(name = "docs") var docs: List<Docs> = listOf(),
    @Json(name = "meta") var meta: Meta? = Meta()
)
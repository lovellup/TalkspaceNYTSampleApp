package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Keywords(
    @Json(name = "name") var name: String? = null,
    @Json(name = "value") var value: String? = null,
    @Json(name = "rank") var rank: Int? = null,
    @Json(name = "major") var major: String? = null
)
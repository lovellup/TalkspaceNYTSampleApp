package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json


data class Legacy(
    @Json(name = "xlarge") var xlarge: String? = null,
    @Json(name = "xlargewidth") var xlargewidth: Int? = null,
    @Json(name = "xlargeheight") var xlargeheight: Int? = null
)
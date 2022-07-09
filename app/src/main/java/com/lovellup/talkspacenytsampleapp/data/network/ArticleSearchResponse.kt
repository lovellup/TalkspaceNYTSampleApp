package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json


data class ArticleSearchResponse(
    @Json(name = "status") var status: String? = null,
    @Json(name = "copyright") var copyright: String? = null,
    @Json(name = "response") var response: Response? = Response()
)
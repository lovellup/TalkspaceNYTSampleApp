package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Byline(
    @Json(name = "original") var original: String? = null,
    @Json(name = "person") var person: List<Person> = listOf(),
    @Json(name = "organization") var organization: String? = null
)
package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Person(
    @Json(name = "firstname") var firstname: String? = null,
    @Json(name = "middlename") var middlename: String? = null,
    @Json(name = "lastname") var lastname: String? = null,
    @Json(name = "qualifier") var qualifier: String? = null,
    @Json(name = "title") var title: String? = null,
    @Json(name = "role") var role: String? = null,
    @Json(name = "organization") var organization: String? = null,
    @Json(name = "rank") var rank: Int? = null
)
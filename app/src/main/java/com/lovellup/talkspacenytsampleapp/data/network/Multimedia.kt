package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json


data class Multimedia(
    @Json(name = "rank") var rank: Int? = null,
    @Json(name = "subtype") var subtype: String? = null,
    @Json(name = "caption") var caption: String? = null,
    @Json(name = "credit") var credit: String? = null,
    @Json(name = "type") var type: String? = null,
    @Json(name = "url") var url: String? = null,
    @Json(name = "height") var height: Int? = null,
    @Json(name = "width") var width: Int? = null,
    @Json(name = "legacy") var legacy: Legacy? = Legacy(),
    @Json(name = "subType") var subType: String? = null,
    @Json(name = "crop_name") var cropName: String? = null
) {
    companion object {
        const val preferredImageSubType = "thumbnail"
        const val imageUrlPrepend = "https://static01.nyt.com/"
    }
}
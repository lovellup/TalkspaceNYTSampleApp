package com.lovellup.talkspacenytsampleapp.data.network

import com.squareup.moshi.Json

data class Docs(
    @Json(name = "abstract") var abstract: String? = null,
    @Json(name = "web_url") var webUrl: String? = null,
    @Json(name = "snippet") var snippet: String? = null,
    @Json(name = "lead_paragraph") var leadParagraph: String? = null,
    @Json(name = "source") var source: String? = null,
    @Json(name = "multimedia") var multimedia: List<Multimedia> = listOf(),
    @Json(name = "headline") var headline: Headline? = Headline(),
    @Json(name = "keywords") var keywords: List<Keywords> = listOf(),
    @Json(name = "pub_date") var pubDate: String? = null,
    @Json(name = "document_type") var documentType: String? = null,
    @Json(name = "news_desk") var newsDesk: String? = null,
    @Json(name = "section_name") var sectionName: String? = null,
    @Json(name = "subsection_name") var subsectionName: String? = null,
    @Json(name = "byline") var byline: Byline? = Byline(),
    @Json(name = "type_of_material") var typeOfMaterial: String? = null,
    @Json(name = "_id") var Id: String? = null,
    @Json(name = "word_count") var wordCount: Int? = null,
    @Json(name = "uri") var uri: String? = null
)
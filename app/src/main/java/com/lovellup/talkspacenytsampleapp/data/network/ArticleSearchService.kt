package com.lovellup.talkspacenytsampleapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleSearchService {
    @GET("articlesearch.json")
    suspend fun getArticlesForQueryString(
        @Query("fq") queryString: String,
        @Query("api-key") apiKey: String
    ): ArticleSearchResponse
}
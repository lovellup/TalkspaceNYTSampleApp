package com.lovellup.talkspacenytsampleapp.data.network

import com.lovellup.talkspacenytsampleapp.data.Article

class ArticleSearchServiceManager(
    private val service: ArticleSearchService,
    private val apiKey: String
) {
    private val requiredArticlesQueryString = "news_desk:(\"Health\" \"Women's Health\" \"Men's Health\" \"Health & Fitness\")"

    suspend fun getRequiredArticles(): List<Article> {
        return service.getArticlesForQueryString(
                requiredArticlesQueryString,
                apiKey
            ).toArticleList()
    }

    private fun ArticleSearchResponse.toArticleList(): List<Article> {
        return this.response?.docs?.map { it.toArticle() } ?: emptyList()
    }

    private fun Docs.toArticle(): Article {
        val headline = this.headline?.main ?: ""
        val abstract = this.abstract ?: ""
        val url = this.webUrl ?: ""
        val multimediaUrl = if (this.multimedia.isEmpty()) {
            ""
        } else if (this.multimedia.any { it.subtype == (Multimedia.preferredImageSubType) }) {
            this.multimedia.find { it.subtype == Multimedia.preferredImageSubType }?.url ?: ""
        } else {
            this.multimedia.first().url
        }

        val fullMultimediaUrl = Multimedia.imageUrlPrepend + multimediaUrl

        return Article(
            headline = headline,
            abstract = abstract,
            url = url,
            multimediaUrl = fullMultimediaUrl
        )
    }
}
package com.lovellup.talkspacenytsampleapp.data.network

import com.lovellup.talkspacenytsampleapp.data.Article

class ArticleSearchServiceManager(
    private val service: ArticleSearchService,
    private val apiKey: String
) {
    suspend fun getRequiredArticles(): List<Article> {
        return articleSearchResponseToArticles(
            service.getArticlesForQueryString(
                "news_desk:(\"Health\" \"Women's Health\" \"Men's Health\" \"Health & Fitness\")",
                apiKey
            )
        )
    }

    private fun articleSearchResponseToArticles(articleSearchResponse: ArticleSearchResponse): List<Article> {
        return articleSearchResponse.response?.docs?.map { docResponseToArticle(it) } ?: emptyList()
    }

    private fun docResponseToArticle(docResponse: Docs): Article {
        val headline = docResponse.headline?.main ?: ""
        val abstract = docResponse.abstract ?: ""
        val url = docResponse.webUrl ?: ""
        val multimediaUrl = if (docResponse.multimedia.isEmpty()) {
            ""
        } else if (docResponse.multimedia.any { it.subtype?.equals("thumbnail") == true }) {
            docResponse.multimedia.find { it.subtype == "thumbnail" }?.url ?: ""
        } else {
            docResponse.multimedia.first().url
        }

        val fullMultimediaUrl = "https://static01.nyt.com/$multimediaUrl"

        return Article(
            headline = headline,
            abstract = abstract,
            url = url,
            multimediaUrl = fullMultimediaUrl
        )
    }
}
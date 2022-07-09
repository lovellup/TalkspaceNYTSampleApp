package com.lovellup.talkspacenytsampleapp.articlelist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.lovellup.talkspacenytsampleapp.data.Article

@Composable
fun ArticleList(articleList: List<Article>) {
    ArticleListing(article = articleList.first())
}
@Composable
fun ArticleListing(article: Article) {
    Text(article.headline)
}
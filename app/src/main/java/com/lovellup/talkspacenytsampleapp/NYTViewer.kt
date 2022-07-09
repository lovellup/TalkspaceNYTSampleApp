package com.lovellup.talkspacenytsampleapp

import android.util.Log
import androidx.compose.runtime.Composable
import com.lovellup.talkspacenytsampleapp.articlelist.ArticleList
import com.lovellup.talkspacenytsampleapp.data.Article

@Composable
fun NYTViewer(articleList: List<Article>, onClick: (Article) -> Unit, onLongPress: (Article) -> Unit) {
    ArticleList(articleList = articleList, onClick, onLongPress)
}
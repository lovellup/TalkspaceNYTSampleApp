package com.lovellup.talkspacenytsampleapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovellup.talkspacenytsampleapp.data.Article
import com.lovellup.talkspacenytsampleapp.data.network.ArticleSearchServiceManager
import kotlinx.coroutines.launch

class MainActivityViewModel(private val articleSearchServiceManager: ArticleSearchServiceManager): ViewModel() {

    var articleList by mutableStateOf(listOf<Article>())
        private set

    init {
        viewModelScope.launch {
            articleList = articleSearchServiceManager.getRequiredArticles()
        }
    }
}
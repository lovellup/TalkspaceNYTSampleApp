package com.lovellup.talkspacenytsampleapp

import android.util.Log
import androidx.compose.runtime.Composable
import com.lovellup.talkspacenytsampleapp.articlelist.ArticleList
import com.lovellup.talkspacenytsampleapp.data.Article

@Composable
fun NYTViewer(onClick: (Article) -> Unit, onLongPress: (Article) -> Unit) {
    val testArticle = Article(
        headline = "Why Does Is It Take Federal Intervention to Fix the N.Y.P.D.?",
        abstract = "The work of holding law enforcement agencies accountable is arduous but vital.",
        url = "https://www.nytimes.com/2022/07/09/opinion/nypd-justice-department-investigation.html",
        multimediaUrl = "https://static01.nyt.com/images/2022/07/09/opinion/09gay1/09gay1-thumbStandard.jpg"
    )
    ArticleList(articleList = listOf(testArticle), onClick, onLongPress)
}
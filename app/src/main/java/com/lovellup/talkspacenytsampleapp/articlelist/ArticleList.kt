package com.lovellup.talkspacenytsampleapp.articlelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lovellup.talkspacenytsampleapp.R
import com.lovellup.talkspacenytsampleapp.data.Article

@Composable
fun ArticleList(articleList: List<Article>) {
    ArticleListing(article = articleList.first())
}
@Composable
fun ArticleListing(article: Article) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(article.multimediaUrl)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.article_multimedia_content_description),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(150.dp)
    )
}
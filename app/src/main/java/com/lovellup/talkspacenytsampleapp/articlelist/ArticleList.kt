package com.lovellup.talkspacenytsampleapp.articlelist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lovellup.talkspacenytsampleapp.R
import com.lovellup.talkspacenytsampleapp.data.Article

@Composable
fun ArticleList(articleList: List<Article>, onClick: (Article) -> Unit, onLongPress: (Article) -> Unit) {
    ArticleListing(article = articleList.first(), onClick, onLongPress)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArticleListing(article: Article, onClick: (Article) -> Unit, onLongPress: (Article) -> Unit) {
    Card(
        Modifier
            .padding(8.dp)
            .combinedClickable(
                onClick = {onClick(article)},
                onLongClick = {onLongPress(article)}
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp) {
        Column(horizontalAlignment = Alignment.Start) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(article.multimediaUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.article_multimedia_content_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = article.headline,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.abstract,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
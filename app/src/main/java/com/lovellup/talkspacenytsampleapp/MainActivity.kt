package com.lovellup.talkspacenytsampleapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.lovellup.talkspacenytsampleapp.data.Article
import com.lovellup.talkspacenytsampleapp.ui.theme.TalkspaceNYTSampleAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val activityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalkspaceNYTSampleAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    NYTViewer(
                        activityViewModel.articleList,
                        this::onArticleClicked,
                        this::onArticleLongPressed
                    )
                }
            }
        }
    }

    private fun onArticleClicked(article: Article) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
        startActivity(intent)
    }

    private fun onArticleLongPressed(article: Article) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, article.url)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}


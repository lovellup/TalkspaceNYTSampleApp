package com.lovellup.talkspacenytsampleapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lovellup.talkspacenytsampleapp.data.Article
import com.lovellup.talkspacenytsampleapp.ui.theme.TalkspaceNYTSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalkspaceNYTSampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    NYTViewer(this::onArticleClicked, this::onArticleLongPressed)
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


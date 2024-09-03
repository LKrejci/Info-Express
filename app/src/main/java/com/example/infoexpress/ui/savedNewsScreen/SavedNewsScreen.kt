package com.example.infoexpress.ui.savedNewsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.infoexpress.ui.compose.NewsLayout
import com.example.infoexpress.ui.domain.UIEvent
import com.example.infoexpress.ui.theme.InfoExpressTheme
import com.example.infoexpress.viewModel.ArticleViewModel

@Composable
fun SavedNewsScreen() {
    val articleViewModel: ArticleViewModel = hiltViewModel()
    articleViewModel.onEvent(UIEvent.GetNews)
    val newsList = articleViewModel.article.value

    InfoExpressTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NewsLayout(newsList)
            }
        }
    }
}
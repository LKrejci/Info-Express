package com.example.infoexpress.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.infoexpress.data.database.entity.Article

@Composable
fun NewsLayout(newsList: List<Article>) {
    LazyColumn {
        items(newsList) {
            ArticleItem(it)
        }
    }
}
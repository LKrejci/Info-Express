package com.example.infoexpress.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.infoexpress.data.Article

@Composable
fun ArticleItem(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
    ) {
        Row(modifier = Modifier.height(120.dp)) {
            article.image?.let {
                ArticleImage(image = it, title = article.title!!)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                article.title?.let { ArticleTitle(title = it) }
//                article.description?.let { ArticleDescription(description = it) }
            }
        }
    }
}

@Composable
fun ArticleImage(image: String, title: String) {
    AsyncImage(
        model = image,
        contentDescription = title,
        contentScale = ContentScale.Crop,
        modifier = Modifier.width(150.dp)
    )
}

@Composable
fun ArticleTitle(title: String) {
    Text(
        text = title,
        // 3 lines for tests purpose
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.titleMedium
    )
}

//@Composable
//fun ArticleDescription(description: String) {
//    Text(
//        text = description,
//        overflow = TextOverflow.Ellipsis,
//        modifier = Modifier.padding(8.dp),
//        style = MaterialTheme.typography.titleSmall
//    )
//}
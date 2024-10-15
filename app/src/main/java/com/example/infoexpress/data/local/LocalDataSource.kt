package com.example.infoexpress.data.local

import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getArticles(): Flow<List<Article>>
    fun insertArticle(article: Article)
    fun deleteArticle(article: Article)
}

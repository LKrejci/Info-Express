package com.example.infoexpress.data.database.repository

import com.example.infoexpress.data.database.entity.Article
import kotlinx.coroutines.flow.Flow


interface Repository {
    fun getArticles(): Flow<List<Article>>
    fun insertArticle(article: Article)
    fun deleteArticle(article: Article)
}
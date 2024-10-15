package com.example.infoexpress.data.repository

import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow


interface Repository {
    fun getArticles(): Flow<List<Article>>
    fun insertArticle(article: Article)
    fun deleteArticle(article: Article)
}
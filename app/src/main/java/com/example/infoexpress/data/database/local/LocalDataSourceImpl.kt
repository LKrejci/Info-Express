package com.example.infoexpress.data.database.local

import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.entity.Article
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val dao: ArticleDao) : LocalDataSource {
    override fun getArticles(): Flow<List<Article>> {
        return dao.getArticles()
    }

    override fun insertArticle(article: Article) {
        dao.insertArticle(article)
    }

    override fun deleteArticle(article: Article) {
        dao.deleteArticle(article)
    }
}
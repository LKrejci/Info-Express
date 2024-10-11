package com.example.infoexpress.data.database.repository

import com.example.infoexpress.data.database.entity.Article
import com.example.infoexpress.data.database.local.LocalDataSource
import com.example.infoexpress.data.database.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val localDataSource: LocalDataSource,
                     private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getArticles(): Flow<List<Article>> {
        return try {
            remoteDataSource.getArticles()
        } catch (e: Exception) {
            localDataSource.getArticles()
        }
    }

    override fun insertArticle(article: Article){
        localDataSource.insertArticle(article)
    }

    override fun deleteArticle(article: Article) {
        localDataSource.deleteArticle(article)
    }
}
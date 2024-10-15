package com.example.infoexpress.data.repository

import com.example.infoexpress.data.entity.Article
import com.example.infoexpress.data.local.LocalDataSource
import com.example.infoexpress.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getArticles(): Flow<List<Article>> {
        return localDataSource.getArticles()
    }

    override fun insertArticle(article: Article){
        localDataSource.insertArticle(article)
    }

    override fun deleteArticle(article: Article) {
        localDataSource.deleteArticle(article)
    }
}
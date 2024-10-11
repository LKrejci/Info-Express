package com.example.infoexpress.data.database.remote

import com.example.infoexpress.data.database.entity.Article
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}
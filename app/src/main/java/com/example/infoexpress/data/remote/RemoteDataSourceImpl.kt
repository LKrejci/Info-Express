package com.example.infoexpress.data.remote

import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}
package com.example.infoexpress.data.database.remote

import com.example.infoexpress.data.database.entity.Article
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getArticles(): Flow<List<Article>>
}

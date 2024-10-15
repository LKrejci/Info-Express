package com.example.infoexpress.data.remote

import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getArticles(): Flow<List<Article>>
}

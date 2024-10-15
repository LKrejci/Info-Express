package com.example.infoexpress.di

import android.content.Context
import androidx.room.Room
import com.example.infoexpress.data.ArticleDatabase
import com.example.infoexpress.data.dao.ArticleDao
import com.example.infoexpress.data.local.LocalDataSource
import com.example.infoexpress.data.local.LocalDataSourceImpl
import com.example.infoexpress.data.remote.RemoteDataSource
import com.example.infoexpress.data.remote.RemoteDataSourceImpl
import com.example.infoexpress.data.repository.Repository
import com.example.infoexpress.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return Room.databaseBuilder(context, ArticleDatabase::class.java, "article-database").build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(articleDatabase: ArticleDatabase): ArticleDao {
        return articleDatabase.articleDao
    }

    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): LocalDataSource {
        return LocalDataSourceImpl(articleDao)
    }

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): Repository = RepositoryImpl(localDataSource, remoteDataSource)
}
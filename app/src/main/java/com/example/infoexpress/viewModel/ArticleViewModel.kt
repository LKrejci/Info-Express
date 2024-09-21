package com.example.infoexpress.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.entity.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val dao: ArticleDao) : ViewModel() {

    private val _article = MutableStateFlow(emptyList<Article>())
    val article: StateFlow<List<Article>> = _article.asStateFlow()

    init {
        getArticlesData()
    }

    fun shouldSaveArticle(isSaved: Boolean, article: Article) {
        article.isFavorite = isSaved

        if (isSaved) {
            insertDate(article)
        } else {
            deleteData(article)
        }
    }

    private fun getArticlesData() {
        viewModelScope.launch(IO) {
            dao.getArticles().collectLatest {
                _article.tryEmit(it)
            }
        }
    }

    private fun insertDate(article: Article) {
        viewModelScope.launch(IO) {
            dao.insertArticle(article)
            getArticlesData()
        }
    }

    private fun deleteData(article: Article) {
        viewModelScope.launch(IO) {
            dao.deleteArticle(article)
            getArticlesData()
        }
    }
}
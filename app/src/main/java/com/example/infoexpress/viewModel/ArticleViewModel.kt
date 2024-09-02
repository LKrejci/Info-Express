package com.example.infoexpress.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.entity.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val dao: ArticleDao): ViewModel() {

    private val _state: MutableState<List<Article>> = mutableStateOf(emptyList())
    val state: State<List<Article>> = _state

    private fun getArticlesData() {
        viewModelScope.launch {
            _state.value = dao.getArticles()
        }
    }

    fun insertDate(article: Article) {
        viewModelScope.launch {
            dao.insertArticle(article)
            getArticlesData()
        }
    }

    fun deleteData(article: Article) {
        viewModelScope.launch {
            dao.deleteArticle(article)
            getArticlesData()
        }
    }
}
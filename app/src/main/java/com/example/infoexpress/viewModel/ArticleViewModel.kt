package com.example.infoexpress.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.entity.Article
import com.example.infoexpress.ui.domain.UIEvent
import com.example.infoexpress.ui.domain.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val dao: ArticleDao) : ViewModel() {

    private val _article: MutableState<List<Article>> = mutableStateOf(emptyList())
    val article: State<List<Article>> = _article

    private val _uiState = mutableStateOf(UIState())
    val uiState: State<UIState> = _uiState

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.TitleChanged -> {
                _uiState.value = _uiState.value.copy(
                    title = event.title
                )
            }

            is UIEvent.DescriptionChanged -> {
                _uiState.value = _uiState.value.copy(
                    description = event.description
                )
            }

            is UIEvent.ImageChanged -> {
                _uiState.value = _uiState.value.copy(
                    image = event.image
                )
            }

            is UIEvent.SaveIconChanged -> {
                _uiState.value = _uiState.value.copy(
                    saveIcon = event.state
                )
            }

            UIEvent.GetNews -> {
                getArticlesData()
            }

            UIEvent.Submit -> {
                shouldSaveArticle(_uiState.value.saveIcon)
            }
        }
    }

    private fun shouldSaveArticle(state: Boolean) {
        val article = Article(
            _uiState.value.title,
            _uiState.value.description,
            _uiState.value.image
        )

        if (state) {
            insertDate(article)
        }
        else {
            deleteData(article)
        }
    }

    private fun getArticlesData() {
        viewModelScope.launch {
            _article.value = dao.getArticles()
        }
    }

    private fun insertDate(article: Article) {
        viewModelScope.launch {
            dao.insertArticle(article)
            getArticlesData()
        }
    }

    private fun deleteData(article: Article) {
        viewModelScope.launch {
            dao.deleteArticle(article)
            getArticlesData()
        }
    }
}
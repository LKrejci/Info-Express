package com.example.infoexpress.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infoexpress.data.repository.Repository
import com.example.infoexpress.data.entity.Article
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val currentLanguage: String = "pt"

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
            repository.getArticles().collectLatest {
                _article.tryEmit(it)
            }
        }
    }

    private fun insertDate(article: Article) {
        viewModelScope.launch(IO) {
            repository.insertArticle(article)
            getArticlesData()
        }
    }

    private fun deleteData(article: Article) {
        viewModelScope.launch(IO) {
            repository.deleteArticle(article)
            getArticlesData()
        }
    }

    fun processTranslation(targetLanguage: String) {
        article.value.forEach(
            action = {
                it.title = translateText(it.title, targetLanguage)
                it.description = translateText(it.description, targetLanguage)
            }
        )
    }

    private fun translateText(
        text: String,
        targetLanguage: String,
    ): String {
        var processedText = ""
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(currentLanguage)
            .setTargetLanguage(targetLanguage)
            .build()

        val translator = Translation.getClient(options)

        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                translator.translate(text)
                    .addOnSuccessListener { translatedText ->
                        processedText = translatedText
                    }
                    .addOnFailureListener { exception ->

                    }
            }
            .addOnFailureListener { exception ->

            }

        return processedText
    }
}
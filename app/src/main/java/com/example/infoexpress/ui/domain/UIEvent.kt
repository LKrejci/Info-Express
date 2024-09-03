package com.example.infoexpress.ui.domain

sealed class UIEvent {
    data class TitleChanged(val title: String): UIEvent()
    data class DescriptionChanged(val description: String): UIEvent()
    data class ImageChanged(val image: String): UIEvent()
    data class SaveIconChanged(val state: Boolean) : UIEvent()
    data object GetNews: UIEvent()
    data object Submit: UIEvent()
}
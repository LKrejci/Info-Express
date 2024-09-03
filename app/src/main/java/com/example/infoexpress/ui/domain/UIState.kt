package com.example.infoexpress.ui.domain

data class UIState (
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val saveIcon: Boolean = false,
    val hasTitleError: Boolean = false,
    val hasDescriptionError: Boolean = false,
    val hasImageError: Boolean = false
)
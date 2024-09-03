package com.example.infoexpress.ui.domain

object Validator {

    fun validateTitle(title: String): ValidationResult {
        return ValidationResult(title.isNotEmpty())
    }

    fun validateDescription(description: String): ValidationResult {
        return ValidationResult(description.isNotEmpty())
    }

    fun validateImage(image: String): ValidationResult {
        return ValidationResult(image.isNotEmpty())
    }
}

data class ValidationResult (
    val status: Boolean = false
)
package com.example.infoexpress.ui

sealed class Screens (val route : String) {
    data object Home : Screens("home_route")
    data object Saved : Screens("saved_route")
    data object Search : Screens("search_route")
}
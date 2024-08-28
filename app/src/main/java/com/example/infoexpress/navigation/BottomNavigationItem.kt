package com.example.infoexpress.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.infoexpress.ui.Screens

sealed class BottomNavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
) {
    data object Home : BottomNavigationItem(
        label = "Home",
        icon = Icons.Filled.Home,
        route = Screens.Home.route
    )
    data object Saved : BottomNavigationItem(
        label = "Saved",
        icon = Icons.Filled.Favorite,
        route = Screens.Saved.route
    )
    data object Search : BottomNavigationItem(
        label = "Search",
        icon = Icons.Filled.Search,
        route = Screens.Search.route
    )
}
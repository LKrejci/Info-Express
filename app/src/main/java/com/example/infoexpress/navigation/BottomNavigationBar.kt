package com.example.infoexpress.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.infoexpress.R
import com.example.infoexpress.ui.Screens
import com.example.infoexpress.ui.homeScreen.HomeScreen
import com.example.infoexpress.ui.savedNewsScreen.SavedNewsScreen
import com.example.infoexpress.ui.searchNewsScreen.SearchNewsScreen

@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomNavigationItem.Saved,
        BottomNavigationItem.Home,
        BottomNavigationItem.Search
    )

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() },
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem (
                        selected = item.route == currentDestination?.route,
                        label = {
                            Text(item.label)
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.label
                            )
                        },
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(Screens.Home.route) {
                HomeScreen()
            }
            composable(Screens.Search.route) {
                SearchNewsScreen()
            }
            composable(Screens.Saved.route) {
                SavedNewsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) }
    )
}
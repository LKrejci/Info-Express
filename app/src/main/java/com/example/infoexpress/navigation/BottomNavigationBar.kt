package com.example.infoexpress.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
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
import com.example.infoexpress.viewModel.ArticleViewModel

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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() },
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
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
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
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
    val articleViewModel: ArticleViewModel = hiltViewModel()

    var openDialog by remember {
        mutableStateOf(false)
    }

    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }

    val itemPosition = remember {
        mutableIntStateOf(0)
    }

    val languages = listOf("pt", "en", "es", "fr", "it")

    var languageSelected = ""

    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        actions = {
            IconButton(onClick = { openDialog = true }) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "Translate")
                if (openDialog) {
                    Dialog(onDismissRequest = { openDialog = false }) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize(),
                            shape = RoundedCornerShape(16.dp),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "Translator AI",
                                    modifier = Modifier.padding(16.dp)
                                )
                                Text(
                                    text = "Choose the language to translate",
                                    modifier = Modifier.padding(16.dp)
                                )
                                Box(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.clickable {
                                            isDropDownExpanded.value = true
                                        }
                                    ) {
                                        Text(text = languages[itemPosition.intValue])
                                        Image(
                                            imageVector = Icons.Filled.ArrowDropDown,
                                            contentDescription = "DropDown Icon"
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = isDropDownExpanded.value,
                                        onDismissRequest = {
                                            isDropDownExpanded.value = false
                                        }) {
                                        languages.forEachIndexed { index, username ->
                                            DropdownMenuItem(text = {
                                                Text(text = username)
                                            },
                                                onClick = {
                                                    isDropDownExpanded.value = false
                                                    itemPosition.intValue = index
                                                    languageSelected = languages[index]
                                                })
                                        }
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    Button(
                                        onClick = { openDialog = false },
                                        modifier = Modifier.padding(8.dp)
                                    ) {
                                        Text(text = "Cancel")
                                    }
                                    Button(
                                        onClick = {
                                            articleViewModel.processTranslation(languageSelected)
                                            openDialog = false },
                                        modifier = Modifier.padding(8.dp)
                                    ) {
                                        Text(text = "Confirm")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
package com.example.infoexpress.ui.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.infoexpress.ui.compose.NewsLayout
import com.example.infoexpress.ui.theme.InfoExpressTheme

@Composable
fun HomeScreen() {
    InfoExpressTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NewsLayout()
            }
        }
    }
}
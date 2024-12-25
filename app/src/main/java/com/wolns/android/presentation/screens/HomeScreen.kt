package com.wolns.android.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {
    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

}
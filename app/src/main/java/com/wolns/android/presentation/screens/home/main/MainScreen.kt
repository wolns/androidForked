package com.wolns.android.presentation.screens.home.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    MainScreenContent()
}

@Composable
private fun MainScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text("Home Screen")
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        MainScreenContent()
    }
}
package com.wolns.android.presentation.screens.home.friends

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
fun FriendsScreen() {
    FriendsScreenContent()
}

@Composable
private fun FriendsScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text("Friends Screen")
        }
    }
}

@Preview
@Composable
private fun FriendsScreenScreenPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        FriendsScreenContent()
    }
}
package com.wolns.android.presentation.screens.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wolns.android.R
import com.wolns.android.presentation.ui.theme.WolnsTheme

@Composable
fun MeScreen() {
    MeScreenContent()
}

@Composable
private fun MeScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Your name",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "@yourLogin",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            FilterChip(
                selected = true,
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = "Connect Yandex Music"
                    )
                }
            )
            FilterChip(
                selected = true,
                enabled = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = "Connect Yandex Music"
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun MeScreenPreview() {
    WolnsTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        MeScreenContent()
    }
}
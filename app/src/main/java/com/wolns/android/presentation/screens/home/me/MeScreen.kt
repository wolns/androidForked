package com.wolns.android.presentation.screens.home.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wolns.android.R
import com.wolns.android.domain.models.User
import com.wolns.android.presentation.models.AuthState
import com.wolns.android.presentation.ui.theme.WolnsTheme

@Composable
fun MeScreen(user: User) {
    MeScreenContent(user = user)
}

@Composable
private fun MeScreenContent(user: User) {
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
                    painter = painterResource(R.drawable.ic_account_circle_96),
                    contentDescription = null,
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = user.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "@${user.login}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))

            AssistChip(
                onClick = {},
                label = {
                    Text(text = stringResource(R.string.connect_to__chip, "Yandex Music"))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.music_note_add_16),
                        contentDescription = null
                    )
                }
            )

            AssistChip(
                onClick = {},
                label = {
                    Text(text = stringResource(R.string.connect_to__chip, "Spotify"))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.music_note_add_16),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun MeScreenPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        MeScreenContent(
            user = User(
                name = "User name",
                login = "userLogin",
                uuid = ""
            )
        )
    }
}
package com.wolns.android.presentation.screens.welocme.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wolns.android.R
import com.wolns.android.presentation.screens.welocme.WelcomeNavigationDestinations

@Composable
fun WelcomeScreen(welcomeNavController: NavController) {

    WelcomeScreenContent(
        onLogInClick = {
            welcomeNavController.navigate(WelcomeNavigationDestinations.LOGIN) {
                popUpTo(welcomeNavController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        onLogUpClick = {
            welcomeNavController.navigate(WelcomeNavigationDestinations.LOGUP) {
                popUpTo(welcomeNavController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

@Composable
private fun WelcomeScreenContent(
    onLogInClick: () -> Unit = {},
    onLogUpClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Box {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedCard {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.displayLarge,
                            fontFamily = FontFamily.Monospace
                        )

                        Text(
                            text = stringResource(R.string.WelcomeScreen_title),
                            style = MaterialTheme.typography.headlineSmall
                        )

                        Spacer(modifier = Modifier.height(48.dp))

                        Button(
                            onClick = onLogInClick,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.LogIn_button)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedButton(
                            onClick = onLogUpClick,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.LogUp_button)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        WelcomeScreenContent()
    }
}
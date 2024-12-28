package com.wolns.android.presentation.screens.welocme.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.wolns.android.R
import com.wolns.android.domain.models.LoginResult
import com.wolns.android.presentation.models.TextFieldData
import com.wolns.android.presentation.viewmodels.LocalMainViewModel

@Composable
fun LoginScreen() {
    val mainViewModel = LocalMainViewModel.current
    LoginScreenContent(
        onLogInClick = { login, password ->
            mainViewModel.login(login = login, password = password) {
                when (it) {
                    is LoginResult.Error -> {}
                    else -> {}
                }
            }
        }
    )
}

@Composable
private fun LoginScreenContent(
    onLogInClick: (login: String, password: String) -> Unit = { _, _ -> },
    errorMessage: String? = null
) {
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .align(Alignment.BottomCenter)
                    .clip(MaterialTheme.shapes.medium.copy(
                        bottomStart = CornerSize(0),
                        bottomEnd = CornerSize(0)
                    ))
                    .background(MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_login_bold_48),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset {
                            IntOffset(
                                x = 0,
                                y = (-48).dp.roundToPx()
                            )
                        }
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))
                        .padding(24.dp)
                )
                
                Column(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    listOf(
                        TextFieldData(
                            value = login,
                            onValueChange = { login = it },
                            label = stringResource(R.string.login_text_field)
                        ),
                        TextFieldData(
                            value = password,
                            onValueChange = { password = it },
                            label = stringResource(R.string.password_text_field)
                        )
                    ).forEach { data ->
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.value,
                            onValueChange = data.onValueChange,
                            label = data.label?.let { { Text(it) } },
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    ElevatedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onLogInClick(login, password) }
                    ) {
                        Text(
                            text = stringResource(R.string.LogIn_button)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenDarkPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        LoginScreenContent()
    }
}

@Preview
@Composable
private fun LoginScreenLightPreview() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        LoginScreenContent()
    }
}
package com.wolns.android.presentation.screens.welocme.logup

import androidx.compose.foundation.background
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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.wolns.android.R
import com.wolns.android.domain.models.UserResult
import com.wolns.android.presentation.models.TextFieldData
import com.wolns.android.presentation.viewmodels.LocalMainViewModel

@Composable
fun LogupScreen() {
    val mainViewModel = LocalMainViewModel.current

    LogupScreenContent(
        onLogUpClick = { name, login, password ->
            mainViewModel.logup(name, login, password) {
                when (it) {
                    is UserResult.Error -> {}
                    else -> {}
                }
            }
        }
    )
}

@Composable
private fun LogupScreenContent(
    onLogUpClick: (name: String, login: String, password: String) -> Unit = { _, _, _ -> },
    errorMessage: String? = null
) {
    var name by rememberSaveable { mutableStateOf("") }
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
                    painter = painterResource(R.drawable.ic_arrow_forward_bold_48),
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
                            value = name,
                            onValueChange = { name = it },
                            label = stringResource(R.string.name_text_field)
                        ),
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
                        onClick = { onLogUpClick(name, login, password) }
                    ) {
                        Text(
                            text = stringResource(R.string.LogUp_button)
                        )
                    }

                    errorMessage?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LogupScreenDarkPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        LogupScreenContent(
            errorMessage = "Error message"
        )
    }
}

@Preview
@Composable
private fun LogupScreenLightPreview() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        LogupScreenContent(
            errorMessage = "Error message"
        )
    }
}
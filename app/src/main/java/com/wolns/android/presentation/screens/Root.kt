package com.wolns.android.presentation.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.wolns.android.presentation.models.AuthState
import com.wolns.android.presentation.screens.home.HomeNavigation
import com.wolns.android.presentation.screens.welocme.WelcomeNavigation
import com.wolns.android.presentation.screens.welocme.welcome.WelcomeScreen
import com.wolns.android.presentation.viewmodels.LocalMainViewModel

@Composable
fun Root() {
    val authState = LocalMainViewModel.current.authState.collectAsState().value ?: return

    when (authState) {
        is AuthState.Authenticated -> {
            HomeNavigation(authState = authState)
        }

        is AuthState.NotAuthenticated -> {
            WelcomeNavigation()
        }
    }
}
package com.wolns.android.presentation.screens.welocme

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wolns.android.presentation.screens.welocme.login.LoginScreen
import com.wolns.android.presentation.screens.welocme.logup.LogupScreen
import com.wolns.android.presentation.screens.welocme.welcome.WelcomeScreen
import com.wolns.android.presentation.viewmodels.MainViewModel
import com.wolns.android.presentation.viewmodels.LocalMainViewModel

@Composable
fun WelcomeNavigation() {
    val mainViewModel: MainViewModel = LocalMainViewModel.current

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WelcomeNavigationDestinations.WELCOME,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(WelcomeNavigationDestinations.WELCOME) {
            WelcomeScreen(
                welcomeNavController = navController
            )
        }

        composable(WelcomeNavigationDestinations.LOGIN) {
            LoginScreen()
        }

        composable(WelcomeNavigationDestinations.LOGUP) {
            LogupScreen()
        }
    }
}
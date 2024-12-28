package com.wolns.android.presentation.screens.home

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wolns.android.presentation.models.AuthState
import com.wolns.android.presentation.screens.home.friends.FriendsScreen
import com.wolns.android.presentation.screens.home.main.MainScreen
import com.wolns.android.presentation.screens.home.me.MeScreen

@Composable
fun HomeNavigation(authState: AuthState.Authenticated) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigationDestinations.MAIN,
            modifier = Modifier.padding(innerPadding),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(HomeNavigationDestinations.MAIN) {
                MainScreen()
            }

            composable(HomeNavigationDestinations.FRIENDS) {
                FriendsScreen()
            }

            composable(HomeNavigationDestinations.ME) {
                MeScreen(authState.user)
            }
        }
    }
}
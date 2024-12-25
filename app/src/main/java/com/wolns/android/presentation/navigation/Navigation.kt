package com.wolns.android.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wolns.android.presentation.screens.FriendsScreen
import com.wolns.android.presentation.screens.HomeScreen
import com.wolns.android.presentation.screens.MeScreen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestinations.HOME,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(NavigationDestinations.HOME) {
            HomeScreen()
        }

        composable(NavigationDestinations.FRIENDS) {
            FriendsScreen()
        }

        composable(NavigationDestinations.ME) {
            MeScreen()
        }
    }
}
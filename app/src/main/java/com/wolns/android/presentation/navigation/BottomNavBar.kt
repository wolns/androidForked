package com.wolns.android.presentation.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wolns.android.R
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("RestrictedApi")
@Composable
fun BottomNavBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        modifier = Modifier.height(70.dp)
    ) {
        listOf(
            BottomNavItem(
                name = R.string.home_nav_button,
                iconIdle = R.drawable.ic_home_outlined_24,
                iconSelected = R.drawable.ic_home_filled_24,
                route = NavigationDestinations.HOME
            ),
            BottomNavItem(
                name = R.string.friends_nav_button,
                iconIdle = R.drawable.ic_friends_outlined_24,
                iconSelected = R.drawable.ic_friends_filled_24,
                route = NavigationDestinations.FRIENDS
            ),
            BottomNavItem(
                name = R.string.me_nav_button,
                iconIdle = R.drawable.ic_me_outlined_24,
                iconSelected = R.drawable.ic_me_filled_24,
                route = NavigationDestinations.ME
            )
        ).forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(if (selected) item.iconSelected else item.iconIdle),
                        contentDescription = stringResource(id = item.name)
                    )
                },
                label = { Text(text = stringResource(id = item.name)) }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    MaterialTheme {
        Surface {
            BottomNavBar(rememberNavController())
        }
    }
}
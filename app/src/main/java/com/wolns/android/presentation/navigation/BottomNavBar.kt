package com.wolns.android.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class BottomNavItem(
    @StringRes val name: Long,
    @DrawableRes val iconIdle: Long,
    @DrawableRes val iconSelected: Long,
    val route: String
)


@Composable
fun BottomNavBar(navHostController: NavHostController) {
    NavigationBar(
        modifier = Modifier.height(70.dp)
    ) {
    }
}

@Preview
@Composable
fun BottomNavBarPreview() {
    MaterialTheme {
        Surface {

        }
    }
}
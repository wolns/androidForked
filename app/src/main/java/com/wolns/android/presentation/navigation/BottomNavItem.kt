package com.wolns.android.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem(
    @StringRes val name: Int,
    @DrawableRes val iconIdle: Int,
    @DrawableRes val iconSelected: Int,
    val route: String
)
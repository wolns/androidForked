package com.wolns.android.presentation.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem(
    @StringRes val name: Int,
    @DrawableRes val iconIdle: Int,
    @DrawableRes val iconSelected: Int,
    val route: String
)
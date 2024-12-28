package com.wolns.android.presentation.viewmodels

import androidx.compose.runtime.staticCompositionLocalOf

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> { error("MainViewModel not found") }
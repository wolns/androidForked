package com.wolns.android.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.Single

@Single
fun provideAppDispatchers(): AppDispatchers = AppDispatchers(
    ui = Dispatchers.Main,
    io = Dispatchers.IO,
    default = Dispatchers.Default
)

class AppDispatchers(
    val ui: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val default: CoroutineDispatcher
)
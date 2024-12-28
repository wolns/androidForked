package com.wolns.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.wolns.android.presentation.screens.Root
import com.wolns.android.presentation.ui.theme.WolnsTheme
import com.wolns.android.presentation.viewmodels.LocalMainViewModel
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                CompositionLocalProvider(
                    LocalMainViewModel provides koinViewModel()
                ) {
                    WolnsTheme {
                        Root()
                    }
                }
            }
        }
    }
}
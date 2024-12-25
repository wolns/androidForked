package com.wolns.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wolns.android.presentation.navigation.BottomNavBar
import com.wolns.android.presentation.navigation.Navigation
import com.wolns.android.presentation.ui.theme.WolnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WolnsTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavBar()
                    }
                ) { innerPadding ->
                    Navigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
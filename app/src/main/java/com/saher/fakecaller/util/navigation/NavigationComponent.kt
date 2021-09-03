package com.saher.fakecaller.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saher.fakecaller.ui.Greeting
import com.saher.fakecaller.util.navigation.NavGraph.Destinations
import com.saher.fakecaller.ui.theme.FakeCallerTheme

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    FakeCallerTheme {
        NavHost(navController = navController, startDestination = Destinations.home ){
            composable(Destinations.home) { Greeting(name = "Android")}
            composable(Destinations.settings){}
        }
    }
}
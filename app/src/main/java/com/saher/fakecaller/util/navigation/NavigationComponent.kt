package com.saher.fakecaller.util.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.ui.Greeting
import com.saher.fakecaller.ui.components.AppBar
import com.saher.fakecaller.util.navigation.NavGraph.Destinations
import com.saher.fakecaller.ui.theme.FakeCallerTheme

@Composable
fun NavigationComponent(roomViewModel: RoomViewModel) {
    val navController = rememberNavController()

    FakeCallerTheme {
        AppBar()
        NavHost(navController = navController, startDestination = Destinations.home ){
            composable(Destinations.home) { Greeting(name = "Android")}
            composable(Destinations.settings){}
        }
    }
}
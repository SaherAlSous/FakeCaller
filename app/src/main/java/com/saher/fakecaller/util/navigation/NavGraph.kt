package com.saher.fakecaller.util.navigation

import androidx.navigation.NavController
import com.saher.fakecaller.util.navigation.NavGraph.Destinations.home

class NavGraph(navController: NavController) {
    val fakeCaller: () -> Unit ={
        navController.navigate(home)
    }

    object Destinations{
        const val home = "home"
        const val settings = "settings"
    }

}
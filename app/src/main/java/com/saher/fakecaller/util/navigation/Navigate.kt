package com.saher.fakecaller.util.navigation

import androidx.navigation.NavController

object Navigate{

    fun toSettingPage(navController: NavController) {
        navController.navigate(NavGraph.Destinations.settings)
    }

    fun toContact(navController: NavController) {
        navController.navigate(NavGraph.Destinations.contact)
    }

    fun popBackStack(navController: NavController) {
        navController.popBackStack()
    }

    fun toCallingPage(navController: NavController) {
        navController.navigate(NavGraph.Destinations.calling)
    }


}
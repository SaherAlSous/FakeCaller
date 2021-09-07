package com.saher.fakecaller.util.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.ui.components.calling.CallingPage
import com.saher.fakecaller.ui.components.contactlist.Contacts
import com.saher.fakecaller.ui.components.contactpage.ContactPage
import com.saher.fakecaller.ui.components.settings.SettingsPage
import com.saher.fakecaller.util.navigation.NavGraph.Destinations
import com.saher.fakecaller.ui.theme.FakeCallerTheme

@Composable
fun NavigationComponent(roomViewModel: RoomViewModel, context: Context) {
    val navController = rememberNavController()

    FakeCallerTheme {
        NavHost(navController = navController, startDestination = Destinations.home ){
            composable(Destinations.home) { Contacts(roomViewModel,navController)}
            composable(Destinations.settings){ SettingsPage(roomViewModel,navController,context)}
            composable(Destinations.contact){ ContactPage(navController)}
            composable(Destinations.calling){CallingPage(navController)}
        }
    }
}
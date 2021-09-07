package com.saher.fakecaller.ui.components.settings

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel

@Composable
fun SettingsPage(roomViewModel: RoomViewModel,navController: NavController, context: Context) {
Column(modifier = Modifier.fillMaxSize()) {
    SettingsAppBar(navController)
    ChoosingRingTone(roomViewModel,context)
    }
}
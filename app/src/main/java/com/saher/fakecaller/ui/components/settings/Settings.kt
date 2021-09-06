package com.saher.fakecaller.ui.components.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SettingsPage(navController: NavController) {
Column(modifier = Modifier.fillMaxSize()) {
    SettingsAppBar(navController)
    ChoosingRingTone()
    }
}
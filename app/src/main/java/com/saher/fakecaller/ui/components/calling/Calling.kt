package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@Composable
fun CallingPage(navController: NavController) {
    ConstraintLayout(
        modifier =
        Modifier.fillMaxSize(),
        constraintSet = callingPageConstraints()
    ) {
        Background()
        CallingText()
        CallTimer()
        ResponseButtons(navController)
        RejectButton(navController)
    }
}
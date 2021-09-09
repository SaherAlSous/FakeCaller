package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel
import java.util.*

@Composable
fun CallingPage(roomViewModel:RoomViewModel ,navController: NavController) {
    ConstraintLayout(
        modifier =
        Modifier.fillMaxSize(),
        constraintSet = callingPageConstraints()
    ) {
        Background(roomViewModel)
        CallTimer(roomViewModel)
        ResponseButtons(roomViewModel,navController)
        RejectButton(navController)
    }
}
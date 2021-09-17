package com.saher.fakecaller.ui.components.calling

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel
import java.util.*

@Composable
fun CallingPage(context: Context,roomViewModel:RoomViewModel ,navController: NavController) {
    ConstraintLayout(
        modifier =
        Modifier.fillMaxSize(),
        constraintSet = callingPageConstraints()
    ) {
        Background(roomViewModel)
        CallTimer(roomViewModel)
        ResponseButtons(context,roomViewModel,navController)
        RejectButton(context,navController, roomViewModel)
    }
}
package com.saher.fakecaller.ui.components.calling

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saher.fakecaller.R
import com.saher.fakecaller.data.RoomViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ResponseButtons(roomViewModel: RoomViewModel, navController: NavController) {
    AnimatedVisibility(
        visible = roomViewModel.visible.value,
        modifier = Modifier
            .layoutId("answeringButtons"),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier =
            Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_reject_call_24
                ),
                contentDescription = "Reject Call",
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape)
                    .padding(24.dp)
                    .clickable { rejectCall(roomViewModel, navController) }
            )
            Image(
                painter = painterResource(
                    id = R.drawable.ic_accept_call_24
                ),
                contentDescription = "Accept Call",
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape)
                    .padding(24.dp)
                    .clickable { acceptCall(roomViewModel) }
            )
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RejectButton(navController: NavController, roomViewModel: RoomViewModel) {
    AnimatedVisibility(
        visible = !roomViewModel.visible.value,
        modifier = Modifier.layoutId("endCall")
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_reject_call_24
                ),
                contentDescription = "Reject Call",
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape)
                    .padding(24.dp)
                    .clickable { endCall(navController, roomViewModel) }
            )
        }
    }
}


fun endCall(
    navController: NavController,
    roomViewModel: RoomViewModel
) {
    navController.popBackStack()
    roomViewModel.endTimer()
}

private fun acceptCall(roomViewModel: RoomViewModel) {
    roomViewModel.stopRingtone()
    roomViewModel.startTimer()
    roomViewModel.visible.value = false
}

private fun rejectCall(
    roomViewModel: RoomViewModel,
    navController: NavController
) {
    roomViewModel.stopRingtone()
    navController.popBackStack()
}
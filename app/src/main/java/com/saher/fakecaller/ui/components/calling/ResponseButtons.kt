package com.saher.fakecaller.ui.components.calling

import android.content.Context
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
import com.saher.fakecaller.util.Chronometer
import com.saher.fakecaller.util.StartRingTone


var visible = mutableStateOf(true)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ResponseButtons(context: Context,roomViewModel: RoomViewModel,navController: NavController) {
    AnimatedVisibility(
        visible = visible.value,
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
                    .clickable { rejectCall(context,roomViewModel ,navController) }
            )
            Image(
                painter = painterResource(
                    id = R.drawable.ic_accept_call_24
                ),
                contentDescription = "Accept Call",
                modifier = Modifier
                    .border(2.dp, Color.White, CircleShape)
                    .padding(24.dp)
                    .clickable { acceptCall(context,roomViewModel) }
            )
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RejectButton(context: Context,navController: NavController, roomViewModel: RoomViewModel) {
    AnimatedVisibility(
        visible = !visible.value,
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
                    .clickable { endCall(context, navController, roomViewModel ) }
            )
        }
    }
}

fun endCall(context: Context, navController: NavController, roomViewModel: RoomViewModel) {
    val startRingTone = StartRingTone(context)
    startRingTone.startStopRingtone()
    navController.popBackStack()
    roomViewModel.endTimer()
}

private fun acceptCall(context: Context, roomViewModel: RoomViewModel){
    val startRingTone = StartRingTone(context)
    startRingTone.startStopRingtone()
    roomViewModel.startTimer()
    visible.value = false
}
private fun rejectCall(context: Context, roomViewModel: RoomViewModel, navController: NavController) {
    val startRingTone = StartRingTone(context)
    startRingTone.startStopRingtone()
    navController.popBackStack()
    roomViewModel.endTimer()
}
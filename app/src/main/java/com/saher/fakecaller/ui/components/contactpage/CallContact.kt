package com.saher.fakecaller.ui.components.contactpage

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saher.fakecaller.R
import com.saher.fakecaller.util.StartRingTone
import com.saher.fakecaller.util.navigation.NavGraph

@Composable
fun CallContact(context: Context,navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId("calling"),
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(
            onClick = { startCaller(context,navController) },
            modifier = Modifier.padding(end = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_add_call_24),
                contentDescription = "Call Contact")
        }
    }
}

fun startCaller(context:Context,navController: NavController) {
    val startRingTone = StartRingTone(context)
    startRingTone.startStopRingtone()
    navController.navigate(NavGraph.Destinations.calling)
}

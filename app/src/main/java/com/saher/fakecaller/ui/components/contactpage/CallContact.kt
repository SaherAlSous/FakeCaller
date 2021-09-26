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
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.StartRingTone
import com.saher.fakecaller.util.navigation.NavGraph
import com.saher.fakecaller.util.navigation.Navigate

@Composable
fun CallContact(roomViewModel: RoomViewModel,navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId("calling"),
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(
            onClick = { startCaller(roomViewModel,navController) },
            modifier = Modifier.padding(end = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_add_call_24),
                contentDescription = "Call Contact")
        }
    }
}

fun startCaller(roomViewModel: RoomViewModel,navController: NavController) {
    roomViewModel.startRingtone()
    roomViewModel.visible.value = true
    Navigate.toCallingPage(navController)
}

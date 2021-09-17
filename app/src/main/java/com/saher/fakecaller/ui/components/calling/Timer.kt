package com.saher.fakecaller.ui.components.calling

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.saher.fakecaller.data.RoomViewModel

var text by mutableStateOf("")

@Composable
fun CallTimer(roomViewModel: RoomViewModel) {
     ObserverTimer(roomViewModel)
    //Timer is not updating
    Text(
        text = text,
        modifier = Modifier.layoutId("timer"),
        fontSize = 24.sp,
        color = Color.White,
        )
}

@Composable
fun ObserverTimer(roomViewModel: RoomViewModel) {
roomViewModel.timerText.observe(
    LocalLifecycleOwner.current,
    Observer {
      text =  it
    }
)
}

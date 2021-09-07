package com.saher.fakecaller.ui.components.calling

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.sp
import com.saher.fakecaller.util.Chronometer

@Composable
fun CallTimer() {
    val chronos = Chronometer()
    //Timer is not updating
    Text(
        text = if ((chronos.timerText).isBlank()) "00:00:00" else chronos.timerText ,
        modifier = Modifier.layoutId("timer"),
        fontSize = 24.sp,
        color = Color.White,
        )
}

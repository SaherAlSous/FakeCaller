package com.saher.fakecaller.ui.components.calling

import android.animation.TimeAnimator
import android.widget.Chronometer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import java.util.*

@Preview
@Composable
fun CallTimer() {
    /**
     * I will on work on this tomorrow, it seems it needs a class in Util
     */
    Text(
        text = "Timer",
        modifier = Modifier.layoutId("timer")
    )
}
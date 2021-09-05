package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.sp

@Composable
fun CallingText() {
        Text(
            text = "Calling...",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.layoutId("callingText")
        )
}
package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CallingPage() {
    Surface(
        modifier =
        Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Background()
        CallingText()
        CallTimer()
        ResponseButtons()
        RejectButton()
    }
}
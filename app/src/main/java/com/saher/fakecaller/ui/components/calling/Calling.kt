package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun CallingPage() {
    ConstraintLayout(
        modifier =
        Modifier.fillMaxSize(),
        constraintSet = callingPageConstraints()
    ) {
        Background()
        CallingText()
        CallTimer()
        ResponseButtons()
        RejectButton()
    }
}
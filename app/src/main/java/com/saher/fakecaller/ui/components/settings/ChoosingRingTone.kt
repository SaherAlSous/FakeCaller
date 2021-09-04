package com.saher.fakecaller.ui.components.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun ChoosingRingTone() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = "RingTone Title",
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Choose RingTone")
            }
        }
    }
}
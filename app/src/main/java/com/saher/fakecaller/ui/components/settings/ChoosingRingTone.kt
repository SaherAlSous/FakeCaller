package com.saher.fakecaller.ui.components.settings

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.saher.fakecaller.util.getFileNameWithExtension
import rememberGetContentActivityResult

@Composable
fun ChoosingRingTone(context: Context) {
    val getContent = rememberGetContentActivityResult()
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Column {
            getContent.uri.let {
                Text(
                    text = if (it != null) it.getFileNameWithExtension(context)!! else " Choose Ringtone",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                )
            }
            Button(onClick = { getContent.launch("audio/*")}) {
                Text(text = "Choose RingTone")
            }
        }
    }
}
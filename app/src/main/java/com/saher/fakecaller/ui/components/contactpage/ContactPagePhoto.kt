package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import rememberGetContentActivityResult

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ContactPagePhoto() {
    val getContent = rememberGetContentActivityResult()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
        getContent.uri?.let {
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxSize(1f),
                contentDescription = "UserImage",
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(data = it)
            )
        }
    }
    TextButton(
        onClick = { getContent.launch("image/*") },
        modifier = Modifier.layoutId("changePhoto")
    ) {
        Text(
            text = "Change Photo",
        color = Color.Black)
    }
}
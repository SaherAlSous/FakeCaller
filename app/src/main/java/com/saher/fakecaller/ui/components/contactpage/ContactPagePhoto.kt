package com.saher.fakecaller.ui.components.contactpage

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ContactPagePhoto() {
    val imageUriState = remember {
        mutableStateOf<Uri?>(null)
    }
    val pickingUp = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        imageUriState.value = it
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
        imageUriState.value?.let {
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
        onClick = { pickingUp.launch("image/*") },
        modifier = Modifier.layoutId("changePhoto")
    ) {
        Text(
            text = "Change Photo",
        color = Color.Black)
    }
}
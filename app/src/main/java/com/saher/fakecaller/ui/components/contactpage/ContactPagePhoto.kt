package com.saher.fakecaller.ui.components.contactpage

import PickUp
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import com.saher.fakecaller.R
import dev.chrisbanes.accompanist.glide.GlideImage

var imageUriState = mutableStateOf<Uri?>(null)
val pickingUp = PickUp().pick


@Composable
fun ContactPagePhoto() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
        if (imageUriState.value != null){
            GlideImage(
                modifier = Modifier
                    .fillMaxSize(1f),
                data = imageUriState.value!!,
                contentDescription = "UserImage",
                contentScale = ContentScale.Crop
                )
        }else {
            Image(
                modifier = Modifier.fillMaxSize(1f),
                painter = painterResource(id = R.drawable.yara),
                contentDescription = "Contact Photo",
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart,

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
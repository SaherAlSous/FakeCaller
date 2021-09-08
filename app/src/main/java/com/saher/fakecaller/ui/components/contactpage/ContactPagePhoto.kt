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
import com.saher.fakecaller.data.RoomViewModel
import rememberGetContentActivityResult

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ContactPagePhoto(roomViewModel: RoomViewModel) {
    val getContent = rememberGetContentActivityResult()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
       if (roomViewModel.photoUri.value.isBlank()){
           getContent.uri?.let {
               roomViewModel.photoUri.value = it.toString()
               Image(
                   modifier = Modifier
                       .align(Alignment.TopCenter)
                       .fillMaxSize(1f),
                   contentDescription = "UserImage",
                   contentScale = ContentScale.Crop,
                   painter = rememberImagePainter(data = it)
               )
           }
       }else{
           Image(
               modifier = Modifier
                   .align(Alignment.TopCenter)
                   .fillMaxSize(1f),
               contentDescription = "UserImage",
               contentScale = ContentScale.Crop,
               painter = rememberImagePainter(data = roomViewModel.photoUri.value)
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
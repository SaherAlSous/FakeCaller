package com.saher.fakecaller.ui.components.contactpage

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.core.net.toUri
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.convertToBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import rememberGetContentActivityResult

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ContactPagePhoto(context: Context,roomViewModel: RoomViewModel) {
    val getContent = rememberGetContentActivityResult()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
       if (roomViewModel.photoUri.value == null){
           getContent.uri?.let {
               CoroutineScope(IO).launch {
                   roomViewModel.photoUri.value = convertToBitmap(uri = it,context = context, 50,50)
               }
               Image(
                   modifier = Modifier
                       .align(Alignment.TopCenter)
                       .fillMaxSize(1f),
                   contentDescription = "UserImage",
                   contentScale = ContentScale.Crop,
                   painter = rememberImagePainter(data = it)
               )
               println("Photo Uri from Picker= $it")
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
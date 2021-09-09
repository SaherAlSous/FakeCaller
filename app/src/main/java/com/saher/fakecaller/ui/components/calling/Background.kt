package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.layoutId
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.imageloading.rememberDrawablePainter
import com.saher.fakecaller.R
import com.saher.fakecaller.data.RoomViewModel
import java.util.*

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Background(roomViewModel: RoomViewModel) {
    Image(
        painter = rememberImagePainter(data = roomViewModel.photoUri.value) ,
        contentDescription = "Contact Image",
        alpha = 0.4f,
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .layoutId("background")
            .fillMaxSize()
    )

}
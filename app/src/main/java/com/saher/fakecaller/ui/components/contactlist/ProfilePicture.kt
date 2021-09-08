package com.saher.fakecaller.ui.components.contactlist

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.saher.fakecaller.R


@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfilePicture(uri : Bitmap, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Red  /* We can use it this way as well MaterialTheme.colors.lightGreen */
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        val painter = rememberImagePainter(
            data = uri,
            builder = {
                placeholder(R.drawable.yara)
            }
        )
        Image(
            painter = painter,
            contentDescription = "User Image",
            modifier = Modifier.size(imageSize),
        )
    }
}
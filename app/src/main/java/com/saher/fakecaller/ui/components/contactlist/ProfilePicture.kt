package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.saher.fakecaller.R


@Composable
fun ProfilePicture(imageSize: Dp) {
    /**
     * We wrap it in a [Card] to use its properties
     */
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Red  /* We can use it this way as well MaterialTheme.colors.lightGreen */
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(R.drawable.hala),
            contentDescription = "User Image",
            modifier = Modifier.size(imageSize),
        )
    }
}
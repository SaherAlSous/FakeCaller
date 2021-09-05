package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.layoutId
import com.saher.fakecaller.R

@Preview
@Composable
fun ContactPagePhoto() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(1f),
            painter = painterResource(id = R.drawable.yara),
            contentDescription = "Contact Photo",
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart,

        )
    }
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.layoutId("changePhoto")
    ) {
        Text(
            text = "Change Photo",
        color = Color.Black)
    }
}
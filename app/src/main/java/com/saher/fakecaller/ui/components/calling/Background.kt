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
import com.saher.fakecaller.R

@Composable
fun Background() {
    Image(
        painter = painterResource(id = R.drawable.yara) ,
        contentDescription = "Contact Image",
        alpha = 0.4f,
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop,
        modifier = Modifier.layoutId("background").fillMaxSize()
    )

}
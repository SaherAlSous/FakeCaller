package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.saher.fakecaller.R

@Preview
@Composable
fun ProfileCard(/*clickAction:() -> Unit*/) {
    Card( //We changed the default shape of Card to make a cut in the corner.
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(
                align = Alignment.Top
            )
            .clickable { /*clickAction.invoke() */ }, //<-- moving the action to main composable.
        elevation = 8.dp,
        backgroundColor = Color.White // Uses Surface color by default, so we have to override it.
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
           ProfilePicture( 72.dp)
           ProfileContent(alignment =  Alignment.Start)
        }
    }
}



package com.saher.fakecaller.ui.components.calling

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saher.fakecaller.R

@Preview
@Composable
fun ResponseButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier =
        Modifier
            .layoutId("answeringButtons")
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_reject_call_24
            ),
            contentDescription = "Reject Call",
            modifier = Modifier
                .border(2.dp, Color.White, CircleShape)
                .padding(24.dp)
                .clickable {  }
        )
        Image(
            painter = painterResource(
                id = R.drawable.ic_accept_call_24
            ),
            contentDescription = "Accept Call",
            modifier = Modifier
                .border(2.dp, Color.White, CircleShape)
                .padding(24.dp)
                .clickable {  }
        )
    }
}
@Preview
@Composable
fun RejectButton() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.layoutId("endCall")

    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_reject_call_24
            ),
            contentDescription = "Reject Call",
            modifier = Modifier
                .border(2.dp, Color.White, CircleShape)
                .padding(24.dp)
                .clickable {  }
        )
    }
}
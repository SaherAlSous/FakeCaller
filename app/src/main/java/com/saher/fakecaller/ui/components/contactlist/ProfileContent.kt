package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileContent(name: String = "Contact Name", LandLine: String = "022772721",mobile: String = "0569956478", alignment: Alignment.Horizontal) {
    Column(
        modifier =
        Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = LandLine,
            style = MaterialTheme.typography.body2,
        )
        Text(
            text = mobile,
            style = MaterialTheme.typography.body2,
        )
    }
}
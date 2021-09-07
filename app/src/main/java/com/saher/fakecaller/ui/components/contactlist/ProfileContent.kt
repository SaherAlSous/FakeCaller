package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saher.fakecaller.data.contacts.Contact

@Composable
fun ProfileContent(contact: Contact, alignment: Alignment.Horizontal) {
    Column(
        modifier =
        Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = contact.name,
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = contact.land_line.toString(),
            style = MaterialTheme.typography.body2,
        )
        Text(
            text = contact.mobile.toString(),
            style = MaterialTheme.typography.body2,
        )
    }
}
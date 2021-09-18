package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.data.contacts.Contact

@Composable
fun ProfileContent(roomViewModel: RoomViewModel,contact: Contact, alignment: Alignment.Horizontal) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = contact.name,
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = contact.land_line,
            style = MaterialTheme.typography.body2,
        )
        Text(
            text = contact.mobile,
            style = MaterialTheme.typography.body2,
        )
        TextButton(
            onClick = { roomViewModel.deleteContact(contact) },
            modifier = Modifier.align(Alignment.End),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 2.dp,
                pressedElevation = 1.dp
            )
        ) {
            Text(text = "Delete")
        }
    }
}
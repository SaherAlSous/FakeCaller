package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Need Constraint layout and image button
 */

@Preview
@Composable
fun Contacts() {
    AppBar()
    Column(modifier = Modifier.fillMaxSize()) {
    ContactList()
    }
    AddNewContact()
}

@Composable
fun AddNewContact() {
     Row(horizontalArrangement = Arrangement.End,verticalAlignment = Alignment.Bottom) {
         Button(onClick = { /*TODO*/ }) {
             Text(text = "Add Contact")
         }
     }
}
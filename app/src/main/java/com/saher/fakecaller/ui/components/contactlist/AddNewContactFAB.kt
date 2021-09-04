package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp

@Composable
fun AddNewContactFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.layoutId("fab"),
        backgroundColor = Color.Black,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(12.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = "Add new Contact"
        )
    }
}
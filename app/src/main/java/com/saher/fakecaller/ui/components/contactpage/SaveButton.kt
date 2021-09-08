package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel

@Composable
fun SaveButton(navController: NavController,roomViewModel: RoomViewModel) {
    TextButton(onClick = { saveAction(navController,roomViewModel) }) {
        Text(
            text = "Save",
            color = Color.Black
        )
    }
}

private fun saveAction(navController: NavController,roomViewModel: RoomViewModel){
    roomViewModel.createAndSaveContact()
    navController.popBackStack()
}
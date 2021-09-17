package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel

@Composable
fun Contacts(roomViewModel: RoomViewModel, navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = contactListConstraints()
    ) {
        AppBar(navController)
        ContactList(roomViewModel,navController)
        AddNewContactFAB(roomViewModel,navController)
    }
}

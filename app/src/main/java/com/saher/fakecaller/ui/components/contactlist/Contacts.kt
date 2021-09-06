package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@Composable
fun Contacts(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = contactListConstraints()
    ) {
        AppBar(navController)
        ContactList(navController)
        AddNewContactFAB(navController)
    }

}


package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Need Constraint layout and image button
 */

@Preview
@Composable
fun Contacts() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = contactListConstraints()
    ) {
        AppBar()
        ContactList()
        AddNewContactFAB()
    }

}


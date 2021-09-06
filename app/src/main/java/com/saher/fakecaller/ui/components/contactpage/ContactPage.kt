package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@Composable
fun ContactPage(navController: NavController) {
    Surface(color = Color.LightGray) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = contactPageConstraints()
        ) {
            ContactPageBar(navController)
            ContactPagePhoto()
            ContactDetails()
            CallContact(navController)
        }
    }
}
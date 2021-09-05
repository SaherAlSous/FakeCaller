package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ContactPage() {
    Surface(color = Color.LightGray) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = contactPageConstraints()
        ) {
            ContactPageBar()
            ContactPagePhoto()
            ContactDetails()
            CallContact()
        }
    }
}
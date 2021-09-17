package com.saher.fakecaller.ui.components.contactpage

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.BackHandler

@Composable
fun ContactPage(context: Context,roomViewModel: RoomViewModel,navController: NavController,onBack:()-> Unit) {
    Surface(color = Color.LightGray) {
        BackHandler(onBack = onBack)
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = contactPageConstraints()
        ) {
            ContactPageBar(roomViewModel,navController,onBack)
            ContactPagePhoto(context,roomViewModel)
            ContactDetails(roomViewModel,navController)
            CallContact(context,navController)
        }
    }
}
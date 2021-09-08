package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel

@Composable
fun ContactDetails(roomViewModel: RoomViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .layoutId("contactDetails")
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val nameMutableValue = roomViewModel.nameMutableValue
        val landMutableValue = roomViewModel.landMutableValue
        val mobileMutableValue = roomViewModel.mobileMutableValue

        ContactTextField(mutableValue = nameMutableValue, title = "Name")
        ContactTextField(mutableValue = landMutableValue, title = "Landline")
        ContactTextField(mutableValue = mobileMutableValue, title = "Mobile")
        SaveButton(navController,roomViewModel)
    }
}


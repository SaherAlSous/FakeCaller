package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ContactTextField(mutableValue: MutableState<String>, title:String){
    TextField(
        value =mutableValue.value ,
        onValueChange ={
            mutableValue.value = it
        },
        label = { Text(text = title) }
    )
}
package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saher.fakecaller.data.Contact

@Preview
@Composable
fun ContactList() {
    LazyColumn(){
        val contacts = listOf<Contact>()
        items(contacts){ contact ->
            ProfileCard()
        }
    }
}
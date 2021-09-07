package com.saher.fakecaller.ui.components.contactlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.data.contacts.Contact
import com.saher.fakecaller.util.navigation.NavGraph

@Composable
fun ContactList(roomViewModel:RoomViewModel,navController: NavController) {
    val contacts:List<Contact> = roomViewModel.contactList
    GetContacts(roomViewModel)
    LazyColumn(modifier = Modifier.layoutId("lazyColumn")){
        items(contacts){ contact ->
            ProfileCard(contact){
                navController.navigate(NavGraph.Destinations.contact)
            }
        }
    }
}

@Composable
private fun GetContacts(roomViewModel: RoomViewModel){
    roomViewModel.readContactList.observe(
        LocalLifecycleOwner.current){
        roomViewModel.contactList = it
    }
}
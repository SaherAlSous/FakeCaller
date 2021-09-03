package com.saher.fakecaller.data

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.*

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    val readContactList : LiveData<List<Contact>>
    val readFileUri: LiveData<Uri>
    private val repository : Repository

    init {
        val userDao = DataBase.getInstance(application).UserDao()
        val ringDao = DataBase.getInstance(application).RingDao()
        repository = Repository(userDao, ringDao)
        readContactList = repository.getContacts()
        readFileUri = repository.getUri()
    }

    suspend fun getContact(id:UUID): LiveData<Contact>{
        return repository.getContact(id)
    }

    fun addContact(contact: Contact){
        repository.addContact(contact)
    }

    fun updateContact(contact: Contact){
        repository.updateContact(contact)
    }

    fun updateUri(uri: Uri){
        repository.updateUri(uri)
    }

}
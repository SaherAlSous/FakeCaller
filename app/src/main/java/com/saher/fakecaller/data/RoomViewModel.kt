package com.saher.fakecaller.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.saher.fakecaller.data.contacts.Contact
import com.saher.fakecaller.data.ringtone.RingTone

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    val readContactList : LiveData<List<Contact>>
    val readFileUri: LiveData<RingTone>
    private val repository : Repository

    init {
        val dbInstance = DataBase.getInstance(application)
        val userDao = dbInstance.UserDao()
        val ringDao = dbInstance.RingDao()
        repository = Repository(userDao, ringDao)
        readContactList = repository.getContacts
        readFileUri = repository.getUri()
    }

    suspend fun getContact(id:Long): LiveData<Contact>{
        return repository.getContact(id)
    }

    fun addContact(contact: Contact){
        repository.addContact(contact)
    }

    fun updateContact(contact: Contact){
        repository.updateContact(contact)
    }

    fun deleteContact(contact: Contact){
        repository.deleteContact(contact)
    }

    fun updateUri(ringTone: RingTone){
        repository.updateUri(ringTone)
    }

}
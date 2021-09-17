package com.saher.fakecaller.data

import android.app.Application
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.saher.fakecaller.data.contacts.Contact
import com.saher.fakecaller.data.ringtone.RingTone
import com.saher.fakecaller.util.Chronometer
import java.util.*

private const val TAG = "ROOMVIEWMODEL"

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    //update or create contact
    var updateContactBoolean by mutableStateOf(false)

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

    //
    var contactId = mutableStateOf<UUID?>(null)

    //Choosing photo page
    var photoUri = mutableStateOf<Bitmap?>(null)

    //Contact page details
    var nameMutableValue = mutableStateOf("")
    var landMutableValue = mutableStateOf("")
    var mobileMutableValue = mutableStateOf("")

    fun createAndSaveContact(){
        //creating a new contact or updating the current one.
        if (updateContactBoolean){
            val currentContact =
                Contact(
                    id = contactId.value!!,
                    name = nameMutableValue.value,
                    land_line = landMutableValue.value,
                    mobile = mobileMutableValue.value,
                    contact_photo = photoUri.value!!
                )
            Log.d(TAG, "contact updated $currentContact")
            updateContact(currentContact)
            updateContactBoolean = false
            eraseData()
        }else{
            val newContact =
                Contact(
                    id = UUID.randomUUID(),
                    name = nameMutableValue.value,
                    land_line = landMutableValue.value,
                    mobile = mobileMutableValue.value,
                    contact_photo = photoUri.value!!
                )
            Log.d(TAG, "contact created $newContact")
            addContact(newContact)
            eraseData()
        }
    }


    //adding a new contact
    private fun addContact(contact: Contact){
        repository.addContact(contact)
    }

    private fun updateContact(contact: Contact){
        repository.updateContact(contact)
    }

    fun deleteContact(contact: Contact){
        repository.deleteContact(contact)
    }

    fun insertUri(ringTone: RingTone){
        repository.insertUri(ringTone)
    }

    fun updateUri(ringTone: RingTone){
        repository.updateUri(ringTone)
    }

    //Setting page ringTone
    var ringTone: RingTone? by mutableStateOf(null)

    //Contact list page
    var contactList by mutableStateOf(listOf<Contact>())


    private fun eraseData() {
        contactId = mutableStateOf(null)
        photoUri = mutableStateOf(null)
        nameMutableValue = mutableStateOf("")
        landMutableValue = mutableStateOf("")
        mobileMutableValue= mutableStateOf("")

    }


    //Chronometer
    var timerText by mutableStateOf(Chronometer().updateTime())
    fun startTimer() = Chronometer().timerController(true)
    fun endTimer() = Chronometer().timerController(false)

}


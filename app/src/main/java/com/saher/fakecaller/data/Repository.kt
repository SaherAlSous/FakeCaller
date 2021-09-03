package com.saher.fakecaller.data

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.Executors


class Repository(
    private val userDao: UserDao,
    private val ringDao: RingDao
){
    private val executor = Executors.newSingleThreadExecutor()
    private val job = Job()
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)

    //getting contacts to UI
    fun getContacts():LiveData<List<Contact>> = userDao.getContacts()

    //getting contact to contact page
    suspend fun getContact(id:UUID):LiveData<Contact> = userDao.getContact(id)

    //updating contact
    fun updateContact(contact: Contact) {
        executor.execute {
            ioScope.launch {
                userDao.updateContact(contact)
            }
        }
    }

    //adding new contact
    fun addContact(contact: Contact) {
        executor.execute {
            ioScope.launch {
                userDao.addContact(contact)
            }
        }
    }


    //getting Ringtone Uri to media player
    fun getUri():LiveData<Uri> = ringDao.getUri()

    //updating Uri from setting page
    fun updateUri(uri: Uri) {
        executor.execute{
            ioScope.launch {
                ringDao.updateUri(uri)
            }
        }
    }


}
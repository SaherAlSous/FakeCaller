package com.saher.fakecaller.data

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "FakeCaller"

class Repository private constructor(context: Context){

    private val dataBase : DataBase = Room.databaseBuilder(
        context.applicationContext,
        DataBase::class.java,
        DATABASE_NAME).build()

    private val userDao = dataBase.UserDao()
    private val ringDao = dataBase.RingDao()
    private val executor = Executors.newSingleThreadExecutor()
    private val fileDir = context.applicationContext.filesDir


    //getting contacts to UI
    fun getContacts():LiveData<List<Contact>> = userDao.getContacts()

    //getting contact to contact page
    fun getContact(id:UUID):LiveData<Contact> = userDao.getContact(id)

    //updating contact
    fun updateContact(contact: Contact) = userDao.updateContact(contact)

    //adding new contact
    fun addContact(contact: Contact) = userDao.addContact(contact)


    //getting Ringtone Uri to media player
    fun getUri():LiveData<Uri> = ringDao.getUri()

    //updating Uri from setting page
    fun updateUri(uri: Uri) = ringDao.updateUri(uri)

    //Initializing the Repository
    companion object{
        @Volatile
        private var instance : Repository? = null

        fun initialize(context: Context)=
            instance?: synchronized(
                this
            ){
                instance?: Repository(context).also {
                    instance = it
                }
            }

    }

}
package com.saher.fakecaller.data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*


@Dao
interface UserDao {

    //getting data for contact list
    @Query("Select * From Contact")
    fun getAll() : LiveData<List<Contact>>

    //getting data for selected contact page
    @Query("Select * From Contact Where id=:id")
    fun getContact(id: Long): LiveData<Contact>

    //updating contact details
    @Update
    suspend fun updateContact(contact: Contact)

    @Insert
    suspend fun addContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

}
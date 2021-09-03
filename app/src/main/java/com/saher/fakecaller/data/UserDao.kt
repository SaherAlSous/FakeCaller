package com.saher.fakecaller.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*


@Dao
interface UserDao {

    //getting data for contact list
    @Query("Select name & mobile & uri From Contact")
    fun getContacts() : LiveData<List<Contact>>

    //getting data for selected contact page
    @Query("Select * From Contact Where id=:id")
    suspend fun getContact(id: UUID): LiveData<Contact>

    //updating contact details
    @Update
    suspend fun updateContact(contact: Contact)

    @Insert
    suspend fun addContact(contact: Contact)

}
package com.saher.fakecaller.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import android.net.Uri
import androidx.room.Update

@Dao
interface RingDao {

    //getting Uri for media player
    @Query("Select * From RingTone")
    fun getUri(): LiveData<Uri>

    //Updating Uri in db
    @Update
    suspend fun updateUri(uri: Uri)


}
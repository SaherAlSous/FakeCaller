package com.saher.fakecaller.data.ringtone

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface RingDao {

    //getting Uri for media player
    @Query("Select * From RingTone")
    fun getUri(): LiveData<RingTone>

    //Updating Uri in db
    @Update
    suspend fun updateUri(ringTone: RingTone)


}
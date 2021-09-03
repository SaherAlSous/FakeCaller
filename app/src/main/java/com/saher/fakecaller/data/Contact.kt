package com.saher.fakecaller.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val land_line : Int,
    val mobile: Int,
    val uri: Uri
)

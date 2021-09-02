package com.saher.fakecaller.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Contact(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val land_line : Int,
    val mobile: Int,
    val uri: Uri
)

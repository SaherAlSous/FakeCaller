package com.saher.fakecaller.data.contacts

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Contact(
    @PrimaryKey()
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val land_line : String,
    val mobile: String,
    val uri: Uri
)

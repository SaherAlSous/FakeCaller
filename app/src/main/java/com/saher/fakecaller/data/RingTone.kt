package com.saher.fakecaller.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class RingTone(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val uri: Uri
)

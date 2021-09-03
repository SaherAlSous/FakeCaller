package com.saher.fakecaller.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class RingTone(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val uri: Uri
)

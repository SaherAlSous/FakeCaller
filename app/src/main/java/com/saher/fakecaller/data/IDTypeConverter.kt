package com.saher.fakecaller.data

import androidx.room.TypeConverter
import java.util.*

class IDTypeConverter {

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?) : String? {
        return uuid?.toString()
    }
}
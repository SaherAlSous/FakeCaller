package com.saher.fakecaller.data

import android.net.Uri
import androidx.room.TypeConverter
import java.util.*

class IDTypeConverter {

    @TypeConverter
    fun fromString(value: String?): Uri? {
        return if (value == null) null else Uri.parse(value)
    }

    @TypeConverter
    fun toString(uri: Uri?): String {
        return uri.toString()
    }


    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?) : String? {
        return uuid?.toString()
    }
}
package com.saher.fakecaller.data

import android.content.Context
import androidx.room.*
import com.saher.fakecaller.data.contacts.Contact
import com.saher.fakecaller.data.contacts.UserDao
import com.saher.fakecaller.data.ringtone.RingDao
import com.saher.fakecaller.data.ringtone.RingTone


private const val DATABASE_NAME = "FakeCaller"


@Database(entities = [Contact::class, RingTone::class], version = 1, exportSchema = false)
@TypeConverters(IDTypeConverter::class)
abstract class DataBase:RoomDatabase() {

    abstract fun UserDao(): UserDao

    abstract fun RingDao(): RingDao

//Implementing the DataBase
    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        DATABASE_NAME
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
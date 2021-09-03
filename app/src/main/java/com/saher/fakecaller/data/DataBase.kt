package com.saher.fakecaller.data

import android.content.Context
import androidx.room.*


private const val DATABASE_NAME = "FakeCaller"


@Database(entities = [Contact::class, RingTone::class], version = 1, exportSchema = false)
@TypeConverters(IDTypeConverter::class)
abstract class DataBase:RoomDatabase() {

    abstract fun UserDao(): UserDao

    abstract fun RingDao():RingDao

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
                        DATABASE_NAME).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }



}

/*
    java.lang.RuntimeException: cannot find implementation for com.saher.fakecaller.data.DataBase. DataBase_Impl does not exist
        at androidx.room.Room.getGeneratedImplementation(Room.java:97)
        at androidx.room.RoomDatabase$Builder.build(RoomDatabase.java:1358)
        at com.saher.fakecaller.data.DataBase$Companion.getInstance(DataBase.kt:31)
        at com.saher.fakecaller.data.RoomViewModel.<init>(RoomViewModel.kt:18)
        at com.saher.fakecaller.util.RoomViewModelFactory.create(RoomViewModelFactory.kt:14)

 */

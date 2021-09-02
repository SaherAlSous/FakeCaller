package com.saher.fakecaller.data

import androidx.room.*


@Database(entities = [Contact::class,RingTone::class], version = 1)
@TypeConverters(IDTypeConverter::class)
abstract class DataBase:RoomDatabase() {

    abstract fun UserDao(): UserDao

    abstract fun RingDao():RingDao

}
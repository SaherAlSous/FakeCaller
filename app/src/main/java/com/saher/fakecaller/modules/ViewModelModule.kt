package com.saher.fakecaller.modules

import android.content.Context
import com.saher.fakecaller.data.DataBase
import com.saher.fakecaller.data.Repository
import com.saher.fakecaller.data.contacts.UserDao
import com.saher.fakecaller.data.ringtone.RingDao
import com.saher.fakecaller.util.Chronometer
import com.saher.fakecaller.util.StartRingTone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    //Chronometer
    @Provides
    @ViewModelScoped
    fun provideChronometer() : Chronometer {
        return Chronometer()
    }

    //RingTone
    @Provides
    @ViewModelScoped
    fun provideStartRingTone(): StartRingTone {
        return StartRingTone()
    }

    //DataBase
    @Provides
    @ViewModelScoped
    fun getDataBase(@ApplicationContext context: Context): DataBase {
        return DataBase.getInstance(context)
    }

    //DAO
    @Provides
    @ViewModelScoped
    fun getUserDao(db: DataBase): UserDao {
        return db.UserDao()
    }

    @Provides
    @ViewModelScoped
    fun getRingDao(db: DataBase): RingDao {
        return db.RingDao()
    }

    @Provides
    @ViewModelScoped
    fun getRepository(userDao: UserDao, ringDao: RingDao): Repository{
        return Repository(userDao, ringDao)
    }
}
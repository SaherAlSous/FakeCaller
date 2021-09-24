package com.saher.fakecaller.modules

import com.saher.fakecaller.util.Chronometer
import com.saher.fakecaller.util.StartRingTone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideChronometer() : Chronometer {
        return Chronometer()
    }

    @Provides
    @ViewModelScoped
    fun provideStartRingTone(): StartRingTone {
        return StartRingTone()
    }

}
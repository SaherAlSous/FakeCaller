package com.saher.fakecaller.modules

import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

//    @Provides
//    @ActivityScoped
//    fun provideViewModel(application: Application): RoomViewModel {
//        return RoomViewModel(application)
//    }

}
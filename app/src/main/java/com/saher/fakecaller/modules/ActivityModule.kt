package com.saher.fakecaller.modules

import android.content.Context
import androidx.navigation.NavHostController
import com.saher.fakecaller.qualifier.Navigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideContext(@ApplicationContext context: ApplicationContext): ApplicationContext {
        return context
    }
}
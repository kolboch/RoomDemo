package com.kakaboc.roomdemo.activities.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule provides application context
 */
@Singleton
@Module
class AppModule(
        private val application: Application
) {
    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

}
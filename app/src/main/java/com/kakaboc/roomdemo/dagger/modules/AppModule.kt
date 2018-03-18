package com.kakaboc.roomdemo.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule provides application context
 */
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
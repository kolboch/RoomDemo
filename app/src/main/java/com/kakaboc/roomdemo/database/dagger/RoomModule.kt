package com.kakaboc.roomdemo.database.dagger

import android.app.Application
import android.arch.persistence.room.Room
import com.kakaboc.roomdemo.database.AppDatabase
import com.kakaboc.roomdemo.database.DB_NAME
import com.kakaboc.roomdemo.database.model.DaoTraining
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * provides database, dao's and repositories
 */
@Module
class RoomModule(
        application: Application
) {
    private val database = Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return database
    }

    @Singleton
    @Provides
    fun providesTrainingsDao(database: AppDatabase): DaoTraining {
        return database.getTrainingDao()
    }
}
package com.kakaboc.roomdemo.dagger.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.kakaboc.roomdemo.database.AppDatabase
import com.kakaboc.roomdemo.database.DB_NAME
import com.kakaboc.roomdemo.database.data.TrainingDataSource
import com.kakaboc.roomdemo.database.data.TrainingRepository
import com.kakaboc.roomdemo.database.model.DaoTraining
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(
        application: Application
) {
    private var database = Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
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

    @Singleton
    @Provides
    fun trainingRepository(trainingDao: DaoTraining): TrainingRepository {
        return TrainingDataSource(trainingDao)
    }
}
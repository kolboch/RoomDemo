package com.kakaboc.roomdemo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.kakaboc.roomdemo.database.model.DaoExercise
import com.kakaboc.roomdemo.database.model.DaoTraining
import com.kakaboc.roomdemo.database.model.Exercise
import com.kakaboc.roomdemo.database.model.Training


/**
 * Created by Karlo on 2018-03-15.
 */
const val DB_NAME = "training_exercise_db"

@Database(
        entities = [(Training::class), (Exercise::class)],
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTrainingDao(): DaoTraining
    abstract fun getExerciseDao(): DaoExercise
}

class DatabaseInstance {
    companion object {
        private var instance: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            return instance as AppDatabase
        }
    }
}
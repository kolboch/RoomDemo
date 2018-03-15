package com.kakaboc.roomdemo.activities.main

import android.arch.persistence.room.Room
import android.content.Context
import com.kakaboc.roomdemo.database.AppDatabase
import com.kakaboc.roomdemo.database.DatabaseInstance

/**
 * Created by Karlo on 2018-03-15.
 */
class MainPresenter(
        context: Context,
        private val view: MainView
) {

    private val database = DatabaseInstance.getAppDatabase(context)
    private val trainingsDao = database.getTrainingDao()

    fun onTrainingsListRequested() {
        val trainings = trainingsDao.getAllTrainings()
        view.displayTrainings(trainings)
    }
}
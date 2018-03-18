package com.kakaboc.roomdemo.activities.main

import com.kakaboc.roomdemo.database.model.DaoTraining
import javax.inject.Inject

/**
 * Created by Karlo on 2018-03-15.
 */
class MainPresenter(
        private val view: MainView
) {

    @Inject
    lateinit var trainingsDao: DaoTraining

    fun onTrainingsListRequested() {
        val trainings = trainingsDao.getAllTrainings()
        view.displayTrainings(trainings)
    }
}
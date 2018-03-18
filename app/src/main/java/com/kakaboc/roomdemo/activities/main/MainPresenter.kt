package com.kakaboc.roomdemo.activities.main

import com.kakaboc.roomdemo.database.model.DaoTraining
import javax.inject.Inject

/**
 * Created by Karlo on 2018-03-15.
 */
class MainPresenter
@Inject
constructor(
        private val view: MainView,
        private val trainingsDao: DaoTraining
) {
    fun onTrainingsListRequested() {
        val trainings = trainingsDao.getAllTrainings()
        view.displayTrainings(trainings)
    }
}
package com.kakaboc.roomdemo.database.data

import com.kakaboc.roomdemo.database.model.DaoTraining
import com.kakaboc.roomdemo.database.model.Training
import javax.inject.Inject

class TrainingDataSource
@Inject constructor(
        private val trainingDao: DaoTraining
) : TrainingRepository {


    override fun insert(training: Training) {
        trainingDao.insert(training)
    }

    override fun update(vararg trainings: Training) {
        trainingDao.update(*trainings)
    }

    override fun delete(vararg trainings: Training) {
        trainingDao.delete(*trainings)
    }

    override fun getAllTrainings(): List<Training> {
        return trainingDao.getAllTrainings()
    }

    override fun getTraining(trainingID: Int): Training {
        return trainingDao.getTraining(trainingID)
    }
}
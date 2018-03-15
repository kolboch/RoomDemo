package com.kakaboc.roomdemo.activities.training

import android.content.Context
import android.os.Bundle
import com.kakaboc.roomdemo.activities.main.TRAINING_ID
import com.kakaboc.roomdemo.database.DatabaseInstance
import com.kakaboc.roomdemo.database.model.Training

/**
 * Created by Karlo on 2018-03-15.
 */
class TrainingPresenter(
        context: Context,
        private val view: TrainingView
) {


    private val database = DatabaseInstance.getAppDatabase(context)
    private var training: Training? = null

    fun onAddTrainingRequested(trainingName: String) {
        if (training != null) {
            training!!.trainingName = trainingName
            database.getTrainingDao().update(training!!)
            view.showUpdateToast()
        } else {
            database.getTrainingDao().insert(Training(trainingName))
            view.showInsertToast()
        }
    }

    fun onIntentDataReceived(extras: Bundle?) {
        val trainingID = extras?.getInt(TRAINING_ID)
        if (trainingID != null && trainingID != 0) {
            training = database.getTrainingDao().getTraining(trainingID)
            view.setTrainingName(training!!.trainingName)
            view.enableDeleteButton()
        }
    }

    fun onTrainingDeleteRequested() {
        if (training != null) {
            database.getTrainingDao().delete(training!!)
            training = null
            view.setTrainingName("")
            view.disableDeleteButton()
        }
    }
}
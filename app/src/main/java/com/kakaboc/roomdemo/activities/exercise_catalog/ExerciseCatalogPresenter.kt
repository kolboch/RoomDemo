package com.kakaboc.roomdemo.activities.exercise_catalog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.kakaboc.roomdemo.activities.main.TRAINING_ID
import com.kakaboc.roomdemo.database.DatabaseInstance

/**
 * Created by Karlo on 2018-03-15.
 */
class ExerciseCatalogPresenter(
        context: Context,
        private val view: ExerciseCatalogView
) {

    private val database = DatabaseInstance.getAppDatabase(context)
    private val exercisesDao = database.getExerciseDao()
    private var trainingID: Int? = null

    fun onIntentDataReceived(bundle: Bundle?) {
        if (bundle != null) {
            trainingID = bundle.getInt(TRAINING_ID)
        }
    }

    fun onExercisesListRequested() {
        val exercises = exercisesDao.getTrainingExercises(trainingID!!)
        view.displayExercises(exercises)
    }

    fun setUpIntentData(intent: Intent) {
        intent.putExtra(TRAINING_ID, trainingID)
    }
}
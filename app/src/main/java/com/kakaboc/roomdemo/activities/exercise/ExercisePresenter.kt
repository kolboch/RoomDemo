package com.kakaboc.roomdemo.activities.exercise

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.kakaboc.roomdemo.activities.exercise_catalog.EXERCISE_ID
import com.kakaboc.roomdemo.activities.main.TRAINING_ID
import com.kakaboc.roomdemo.database.DatabaseInstance
import com.kakaboc.roomdemo.database.model.Exercise
import com.kakaboc.roomdemo.database.model.Training

/**
 * Created by Karlo on 2018-03-15.
 */
class ExercisePresenter(
        context: Context,
        val view: ExerciseView
) {
    private val database = DatabaseInstance.getAppDatabase(context)
    private var exercise: Exercise? = null
    private lateinit var training: Training

    fun onAddExerciseRequested(exerciseName: String) {
        if (exercise != null) {
            exercise!!.exerciseName = exerciseName
            database.getExerciseDao().update(exercise!!)
            view.showUpdateToast()
        } else {
            database.getExerciseDao().insert(Exercise(training.trainingID!!, exerciseName))
            view.showInsertToast()
        }
    }

    fun onIntentDataReceived(extras: Bundle?) {
        val trainingID = extras?.getInt(TRAINING_ID)
        if (trainingID != null && trainingID != 0) {
            training = database.getTrainingDao().getTraining(trainingID)
        }
        val exerciseID = extras?.getInt(EXERCISE_ID)
        Log.v("LOG_XX", "$exerciseID")
        if (exerciseID != null && exerciseID != 0) {
            exercise = database.getExerciseDao().getExercise(exerciseID)
            view.setExerciseName(exercise!!.exerciseName)
            view.enableDeleteButton()
        }
    }

    fun onExerciseDeleteRequested() {
        if (exercise != null) {
            database.getExerciseDao().delete(exercise!!)
            exercise = null
            view.setExerciseName("")
            view.disableDeleteButton()
        }
    }
}
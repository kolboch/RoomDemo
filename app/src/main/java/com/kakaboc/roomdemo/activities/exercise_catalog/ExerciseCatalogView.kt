package com.kakaboc.roomdemo.activities.exercise_catalog

import com.kakaboc.roomdemo.database.model.Exercise

/**
 * Created by Karlo on 2018-03-15.
 */
interface ExerciseCatalogView {
    fun displayExercises(exercises: List<Exercise>)
}
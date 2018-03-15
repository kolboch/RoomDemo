package com.kakaboc.roomdemo.activities.exercise

/**
 * Created by Karlo on 2018-03-15.
 */
interface ExerciseView {
    fun showInsertToast()
    fun enableDeleteButton()
    fun disableDeleteButton()
    fun showUpdateToast()
    fun setExerciseName(name: String)
}
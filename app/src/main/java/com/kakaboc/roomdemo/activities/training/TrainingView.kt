package com.kakaboc.roomdemo.activities.training

/**
 * Created by Karlo on 2018-03-15.
 */
interface TrainingView {
    fun setTrainingName(name: String)
    fun showInsertToast()
    fun enableDeleteButton()
    fun disableDeleteButton()
    fun showUpdateToast()
}
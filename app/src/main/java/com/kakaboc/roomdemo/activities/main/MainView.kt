package com.kakaboc.roomdemo.activities.main

import com.kakaboc.roomdemo.database.model.Training

/**
 * Created by Karlo on 2018-03-15.
 */
interface MainView {
    fun displayTrainings(trainings: List<Training>)
}
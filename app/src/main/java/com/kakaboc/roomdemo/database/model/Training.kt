package com.kakaboc.roomdemo.database.model

import android.arch.persistence.room.*

/**
 * Created by Karlo on 2018-03-15.
 */
const val TRAINING_TABLE_NAME = "trainings"

@Entity(
        tableName = TRAINING_TABLE_NAME
)
data class Training(
        var trainingName: String
) {
    @PrimaryKey(autoGenerate = true)
    var trainingID: Int? = null
}

@Dao
interface DaoTraining {
    @Insert
    fun insert(training: Training)

    @Update
    fun update(vararg trainings: Training)

    @Delete
    fun delete(vararg trainings: Training)

    @Query("SELECT * FROM $TRAINING_TABLE_NAME")
    fun getAllTrainings(): List<Training>

    @Query("SELECT * FROM $TRAINING_TABLE_NAME WHERE trainingID= :trainingID")
    fun getTraining(trainingID: Int): Training
}
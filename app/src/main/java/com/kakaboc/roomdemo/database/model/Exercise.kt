package com.kakaboc.roomdemo.database.model

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE

/**
 * Created by Karlo on 2018-03-15.
 */
const val EXERCISE_TABLE_NAME = "exercises"

@Entity(
        foreignKeys = [
            (ForeignKey(entity = Training::class,
                    parentColumns = arrayOf("trainingID"),
                    childColumns = arrayOf("trainingID"),
                    onDelete = CASCADE))
        ],
        tableName = EXERCISE_TABLE_NAME
)
data class Exercise(
        val trainingID: Int,
        var exerciseName: String
) {
    @PrimaryKey(autoGenerate = true)
    var exerciseID: Int? = null


}

@Dao
interface DaoExercise {
    @Insert
    fun insert(exercise: Exercise)

    @Update
    fun update(vararg exercises: Exercise)

    @Delete
    fun delete(vararg exercises: Exercise)

    @Query("SELECT * FROM $EXERCISE_TABLE_NAME")
    fun getAllExercises(): List<Exercise>

    @Query("SELECT * FROM $EXERCISE_TABLE_NAME WHERE trainingID = :trainingID")
    fun getTrainingExercises(trainingID: Int): List<Exercise>

    @Query("SELECT * FROM $EXERCISE_TABLE_NAME WHERE exerciseID = :exerciseID")
    fun getExercise(exerciseID: Int): Exercise
}
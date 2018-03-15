package com.kakaboc.roomdemo.activities.exercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kakaboc.roomdemo.R
import kotlinx.android.synthetic.main.activity_training.*

class ExerciseActivity : AppCompatActivity(), ExerciseView {
    private val presenter = ExercisePresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
    }

    override fun showInsertToast() {
        Toast.makeText(this, R.string.successful_training_add, Toast.LENGTH_SHORT).show()
    }
    override fun enableDeleteButton() {
        deleteButton.visibility = View.VISIBLE
    }

    override fun disableDeleteButton() {
        deleteButton.visibility = View.GONE
    }

    override fun showUpdateToast() {
        Toast.makeText(this, R.string.successful_training_update, Toast.LENGTH_SHORT).show()
    }

    override fun setExerciseName(name: String) {

    }
}

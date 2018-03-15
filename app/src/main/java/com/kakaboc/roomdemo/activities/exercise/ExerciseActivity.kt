package com.kakaboc.roomdemo.activities.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kakaboc.roomdemo.R
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity(), ExerciseView {
    private val presenter = ExercisePresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        setUpButtonsListeners()
    }

    override fun onResume() {
        super.onResume()
        presenter.onIntentDataReceived(intent?.extras)
    }

    private fun setUpButtonsListeners() {
        exerciseDeleteButton.setOnClickListener {
            presenter.onExerciseDeleteRequested()
        }
        exerciseSaveButton.setOnClickListener {
            presenter.onAddExerciseRequested(exerciseNameEdit.text.toString())
        }
    }

    override fun showInsertToast() {
        Toast.makeText(this, R.string.successful_exercise_add, Toast.LENGTH_SHORT).show()
    }

    override fun enableDeleteButton() {
        exerciseDeleteButton.visibility = View.VISIBLE
    }

    override fun disableDeleteButton() {
        exerciseDeleteButton.visibility = View.GONE
    }

    override fun showUpdateToast() {
        Toast.makeText(this, R.string.successful_training_update, Toast.LENGTH_SHORT).show()
    }

    override fun setExerciseName(name: String) {
        exerciseNameEdit.setText(name)
    }
}

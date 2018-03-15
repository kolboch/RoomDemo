package com.kakaboc.roomdemo.activities.exercise_catalog

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kakaboc.roomdemo.R
import com.kakaboc.roomdemo.activities.exercise.ExerciseActivity
import com.kakaboc.roomdemo.activities.main.TRAINING_ID
import com.kakaboc.roomdemo.database.model.Exercise
import kotlinx.android.synthetic.main.activity_exercises_catalog.*

const val EXERCISE_ID = "com.kakaboc.exerciseID"

class ExerciseCatalogActivity : AppCompatActivity(), ExerciseCatalogView {

    private val presenter = ExerciseCatalogPresenter(this, this)
    private val adapter = ExercisesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises_catalog)
        presenter.onIntentDataReceived(intent.extras)
        setUpExercisesRecycler()
        setUpButtonListeners()
    }

    private fun setUpExercisesRecycler() {
        exercisesRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        exercisesRecyclerView.adapter = adapter
        adapter.longClickListener = { exerciseID, trainingID ->
            val intent = Intent(baseContext, ExerciseActivity::class.java)
            intent.putExtra(EXERCISE_ID, exerciseID)
            intent.putExtra(TRAINING_ID, trainingID)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onExercisesListRequested()
    }

    override fun displayExercises(exercises: List<Exercise>) {
        adapter.exercises = exercises
        adapter.notifyDataSetChanged()
    }

    private fun setUpButtonListeners() {
        fabAddExercise.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            presenter.setUpIntentData(intent)
            startActivity(intent)
        }
    }

}

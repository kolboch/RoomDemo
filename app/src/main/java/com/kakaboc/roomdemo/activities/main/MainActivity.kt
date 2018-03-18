package com.kakaboc.roomdemo.activities.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kakaboc.roomdemo.R
import com.kakaboc.roomdemo.activities.exercise_catalog.ExerciseCatalogActivity
import com.kakaboc.roomdemo.activities.training.TrainingActivity
import com.kakaboc.roomdemo.dagger.components.DaggerAppComponent
import com.kakaboc.roomdemo.dagger.modules.AppModule
import com.kakaboc.roomdemo.dagger.modules.RoomModule
import com.kakaboc.roomdemo.database.model.Training
import kotlinx.android.synthetic.main.activity_main.*

const val TRAINING_ID = "com.kakaboc.trainID"

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private val adapter = TrainingsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTrainingsRecycler()
        setUpButtonListeners()
        DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .roomModule(RoomModule(application))
                .build()
                .inject(presenter)
    }

    override fun onResume() {
        super.onResume()
        presenter.onTrainingsListRequested()
    }

    private fun setUpTrainingsRecycler() {
        trainingsRecycler.layoutManager = LinearLayoutManager(applicationContext)
        trainingsRecycler.adapter = adapter
        adapter.longClickListener = {
            val intent = Intent(baseContext, TrainingActivity::class.java)
            intent.putExtra(TRAINING_ID, it)
            startActivity(intent)
        }
        adapter.onClickListener = {
            val intent = Intent(baseContext, ExerciseCatalogActivity::class.java)
            intent.putExtra(TRAINING_ID, it)
            startActivity(intent)
        }
    }

    override fun displayTrainings(trainings: List<Training>) {
        adapter.trainingsList = trainings
        adapter.notifyDataSetChanged()
    }

    private fun setUpButtonListeners() {
        fabAddTraining.setOnClickListener {
            startActivity(Intent(this, TrainingActivity::class.java))
        }
    }
}

package com.kakaboc.roomdemo.activities.training

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kakaboc.roomdemo.R
import kotlinx.android.synthetic.main.activity_training.*

class TrainingActivity : AppCompatActivity(), TrainingView {
    private val presenter = TrainingPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)
        setupButtonListeners()
        presenter.onIntentDataReceived(intent?.extras)
    }

    private fun setupButtonListeners() {
        saveButton.setOnClickListener {
            presenter.onAddTrainingRequested(trainingNameEdit.text.toString())
        }
        deleteButton.setOnClickListener {
            presenter.onTrainingDeleteRequested()
        }
    }

    override fun setTrainingName(name: String) {
        trainingNameEdit.setText(name)
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
}

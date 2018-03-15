package com.kakaboc.roomdemo.activities.exercise_catalog

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kakaboc.roomdemo.R
import com.kakaboc.roomdemo.database.model.Exercise
import kotlinx.android.synthetic.main.exercise_item.view.*

/**
 * Created by Karlo on 2018-03-15.
 */
class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder>() {

    lateinit var longClickListener: (Int, Int) -> Unit
    lateinit var exercises: List<Exercise>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val trainingView = LayoutInflater.from(parent.context).inflate(R.layout.exercise_item, parent, false)
        return ExerciseViewHolder(trainingView)
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class ExerciseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(position: Int) {
            itemView.setOnLongClickListener {
                longClickListener.invoke(exercises[position].exerciseID!!, exercises[position].trainingID)
                true
            }
            itemView.exerciseName.text = exercises[position].exerciseName
        }
    }
}
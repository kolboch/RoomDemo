package com.kakaboc.roomdemo.activities.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kakaboc.roomdemo.R
import com.kakaboc.roomdemo.database.model.Training
import kotlinx.android.synthetic.main.training_item.view.*

/**
 * Created by Karlo on 2018-03-15.
 */
class TrainingsAdapter : RecyclerView.Adapter<TrainingsAdapter.TrainingViewHolder>() {

    lateinit var longClickListener: (Int) -> Unit
    lateinit var onClickListener: (Int) -> Unit
    lateinit var trainingsList: List<Training>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val trainingView = LayoutInflater.from(parent.context).inflate(R.layout.training_item, parent, false)
        return TrainingViewHolder(trainingView)
    }

    override fun getItemCount(): Int {
        return trainingsList.size
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class TrainingViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(position: Int) {
            itemView.setOnLongClickListener {
                longClickListener.invoke(trainingsList[position].trainingID!!)
                true
            }
            itemView.setOnClickListener {
                onClickListener.invoke(trainingsList[position].trainingID!!)
            }
            itemView.trainingName.text = trainingsList[position].trainingName
        }
    }

}

package com.example.myappproject.adepters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.R
import com.example.myappproject.models.TestResult

class HistoryAdapter(private val testResults: ArrayList<TestResult>) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var testId : TextView = itemView.findViewById(R.id.testId_text)
        var test : TextView = itemView.findViewById(R.id.test_text)
        var score : TextView = itemView.findViewById(R.id.score_text)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item_history, parent, false)
        return HistoryAdapter.MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HistoryAdapter.MyViewHolder, position: Int) {
        holder.testId.text="Id: "+testResults[position].id.toString()
        holder.test.text="Test: "+testResults[position].testId.toString()
        holder.score.text = "score: "+testResults[position].scored.toString()
    }

    override fun getItemCount(): Int {
        return testResults.size
    }
}
package com.example.myappproject.adepters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.MainActivity
import com.example.myappproject.R
import com.example.myappproject.models.Question

class TestAdapter(private val questions: ArrayList<Question>) : RecyclerView.Adapter<TestAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var questionTextView: TextView = itemView.findViewById(R.id.question_text)
        var radio1: RadioButton = itemView.findViewById(R.id.first_radio)
        var radio2: RadioButton = itemView.findViewById(R.id.second_radio)
        var radio3: RadioButton = itemView.findViewById(R.id.third_radio)
        val radioGroup : RadioGroup = itemView.findViewById(R.id.radio_group)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recylerview_item_test, parent, false)
        return TestAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.questionTextView.text = questions[position].questionText
//        if (questions[position].rowAnswers.size==3){
            holder.radio1.text = questions[position].rowAnswers[0]
            holder.radio2.text = questions[position].rowAnswers[1]
            holder.radio3.text = questions[position].rowAnswers[2]
//        }

        setOnClickRadio(holder.radio1,position)
        setOnClickRadio(holder.radio2,position)
        setOnClickRadio(holder.radio3,position)

//        holder.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
//
//        }
//
//        holder.radioGroup.setOnClickListener {
//
//        }
    }

    fun setOnClickRadio(radio : RadioButton, pos: Int){
        radio.setOnClickListener {
            if (radio.isChecked){
                MainActivity.resultTest.put(questions[pos].id, radio.text as String)
            }
        }
    }

    override fun getItemCount(): Int {
        return questions.size
    }

}
package com.example.myappproject.adepters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.R
import com.example.myappproject.models.Student

class CustomAdapter(private val students: ArrayList<Student>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>()  {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardUsername: TextView = itemView.findViewById(R.id.cardUsername)
        val ratePlace: TextView = itemView.findViewById(R.id.ratePlace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item_profile, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        holder.cardUsername.text = students[position].name
        holder.ratePlace.text = students[position].ratePlace.toString()

//        {
//          quest = position
//          r.id =
//          ans = transition
//          map.put(quest,ans)
//        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
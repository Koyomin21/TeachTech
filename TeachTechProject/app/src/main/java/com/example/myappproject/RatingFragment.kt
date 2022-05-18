package com.example.myappproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.adepters.CustomAdapter
import com.example.myappproject.models.Student


class RatingFragment : Fragment() {
    private lateinit var adapter: CustomAdapter
    private var studentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentList = (activity as MainActivity?)?.getAllStudents()!!
        adapter = CustomAdapter(studentList)
        studentList.forEach { it ->
            Log.d("Rating",it.toString())
        }
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ratePlace = view.findViewById<TextView>(R.id.place_text)
        val totalPlaces = view.findViewById<TextView>(R.id.total_places_text)

        val recyclerView: RecyclerView = view.findViewById(R.id.user_ratings_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
//        val studentList = (activity as MainActivity?)?.getAllStudents()
//        adapter = CustomAdapter(studentList)
        recyclerView.adapter=adapter

        val currentStudent = (activity as MainActivity?)?.getCurrentUser()
        if (currentStudent != null) {
            ratePlace.text = currentStudent.ratePlace.toString()
        }

        totalPlaces.text = (activity as MainActivity?)?.getAllStudentsSize().toString()
    }
}
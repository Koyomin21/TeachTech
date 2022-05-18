package com.example.myappproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.adepters.HistoryAdapter
import com.example.myappproject.models.Student
import com.example.myappproject.models.TestResult


class HistoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.history_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val testRes = (activity as MainActivity).getAllTestResults()
        val testResCopy =  testRes.clone() as ArrayList<TestResult>
        for (res in testResCopy){
            if (res.student.login != (activity as MainActivity).getCurrentUser().login)
                testRes.remove(res)
        }
        recyclerView.adapter=HistoryAdapter(testRes)
        view.findViewById<Button>(R.id.backBtn).setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment_to_profileFragment)
        }
    }


}
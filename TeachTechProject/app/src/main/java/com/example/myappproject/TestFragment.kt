package com.example.myappproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappproject.adepters.TestAdapter


class TestFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // чтобы не ломалась добавить
        if (MainActivity.currentTest !=0) {
            view.findViewById<TextView>(R.id.no_test).visibility = View.GONE
            view.findViewById<Button>(R.id.submitBtn).visibility=View.VISIBLE
            view.findViewById<RecyclerView>(R.id.test_recycler).visibility=View.VISIBLE

            val recyclerView: RecyclerView = view.findViewById(R.id.test_recycler)
            recyclerView.layoutManager = LinearLayoutManager(context)
            val questionAll = (activity as MainActivity).getAllQuestions()
            val questionAll2 = (activity as MainActivity).getAllQuestions()
            questionAll.forEach {
                if (it.testId != MainActivity.currentTest)
                    questionAll2.remove(it)
            }
            Log.d("quiz", questionAll2.toString())
            recyclerView.adapter = TestAdapter(questionAll2)

            //btn onClick
            view.findViewById<Button>(R.id.submitBtn).setOnClickListener {
                (activity as MainActivity).checkAnswer(
                    MainActivity.resultTest,
                    (activity as MainActivity).getCurrentUser()
                )
//            findNavController().navigate(R.id.action_testFragment_to_profileFragment)
                view.findViewById<TextView>(R.id.no_test).visibility = View.VISIBLE
                view.findViewById<Button>(R.id.submitBtn).visibility=View.GONE
                view.findViewById<RecyclerView>(R.id.test_recycler).visibility=View.GONE
            }
        } else{
            view.findViewById<TextView>(R.id.no_test).visibility = View.VISIBLE
            view.findViewById<Button>(R.id.submitBtn).visibility=View.GONE
            view.findViewById<RecyclerView>(R.id.test_recycler).visibility=View.GONE
        }
    }
}
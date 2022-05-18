package com.example.myappproject

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myappproject.models.Student
import com.google.gson.Gson
import java.lang.Exception
import java.util.*


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameTextView = view.findViewById<TextView>(R.id.textView3)
        val surnameTextView = view.findViewById<TextView>(R.id.surnameTextView)
        val dateTextView = view.findViewById<TextView>(R.id.dateTextView)

        val logoutBtn = view.findViewById<Button>(R.id.logout)
        val historyBtn = view.findViewById<Button>(R.id.history_btn)
        val editBtn = view.findViewById<Button>(R.id.edit_btn)

        val currentStudent = (activity as MainActivity?)?.getCurrentUser()

        if (currentStudent!=null){
                nameTextView.text = "Name: "+currentStudent.name
                surnameTextView.text = "Surname: "+currentStudent.surname
                dateTextView.text = "Date of Birth: "+currentStudent.birthDate.toString()
        }


        logoutBtn.setOnClickListener {
            if ((activity as MainActivity?)?.logoutStudent() == true)
                findNavController().navigate(R.id.action_profileFragment_to_entryFragment)
        }

        historyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_historyFragment)
        }

        editBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editFragment)
        }
    }

//     fun getCurrentUser():Student{
//        val sharedPr = activity?.getSharedPreferences("currentUser", Context.MODE_PRIVATE)
//        val infoStudent = sharedPr?.getString("existUser","null")
//        if (infoStudent=="null")
//            return Student()
//        return Gson().fromJson(infoStudent,Student::class.java)
//    }


}
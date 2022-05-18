package com.example.myappproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myappproject.models.Group
import com.example.myappproject.models.Student
import com.google.gson.Gson
import java.time.LocalDate


class SignUpFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.signUp).setOnClickListener {
            val email = view.findViewById<EditText>(R.id.username).text.toString()
            val pass = view.findViewById<EditText>(R.id.password).text.toString()
            val firstName =view.findViewById<EditText>(R.id.first_name).text.toString()
            val surname = view.findViewById<EditText>(R.id.last_name).text.toString()

            val sharedPref = activity?.getSharedPreferences("users", Context.MODE_PRIVATE)
            val editor = sharedPref?.edit()

            val newStudent = Student(email,pass,firstName,surname, LocalDate.parse("2002-04-02"),(activity as MainActivity).getLastRatePlace()+1, Group(1,"NULL"))
            editor?.putString("$email $pass",Gson().toJson(newStudent))
            editor?.apply()
            Toast.makeText(context,"Registration Success",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }
}
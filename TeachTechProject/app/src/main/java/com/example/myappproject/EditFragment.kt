package com.example.myappproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstname : EditText = view.findViewById(R.id.first_name_edit)
        val surname : EditText = view.findViewById(R.id.last_name_edit)
        val pass : EditText = view.findViewById(R.id.password_edit)

        val student = (activity as MainActivity).getCurrentUser()



        view.findViewById<Button>(R.id.change_btn).setOnClickListener {
            Log.d("changeData",firstname.text.toString())
            if (firstname.text.toString()!="")
                student.name= firstname.text.toString()
            Log.d("changeData",surname.text.toString())
            if (surname.text.toString()!="")
                student.surname = surname.text.toString()
            Log.d("changeData",pass.text.toString())
            if (pass.text.toString()!="")
                student.password = pass.text.toString()
            Log.d("changeData edit",student.name+" "+student.surname+" "+student.password)
            if((activity as MainActivity).changeUserData(student.name,student.surname,student.password)){
//                if ((activity as MainActivity).logoutStudent())
                    findNavController().navigate(R.id.action_editFragment_to_profileFragment)
            }

        }
    }


}
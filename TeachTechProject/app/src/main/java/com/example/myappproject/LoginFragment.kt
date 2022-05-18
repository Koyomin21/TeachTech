package com.example.myappproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myappproject.models.Student
import com.google.gson.Gson


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginBtn = view.findViewById<Button>(R.id.loginBtn)

        val sharedPref = activity?.getSharedPreferences("users",Context.MODE_PRIVATE)
        val sharedPref2 = activity?.getSharedPreferences("currentUser",Context.MODE_PRIVATE)

        loginBtn.setOnClickListener {
            val passView = view.findViewById<EditText>(R.id.password)
            val emailView = view.findViewById<EditText>(R.id.email)

            val pass =  passView.text.toString()
            val email = emailView.text.toString()

            val loginUser = sharedPref?.getString("$email $pass", "NotFound")

            val editor = sharedPref2?.edit()

            if (loginUser=="NotFound"){
                passView.setText("")
                emailView.setText("")                     //test@gmail.com|password
                Toast.makeText(context,"Incorrect data",Toast.LENGTH_LONG).show()

                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setTitle("Fail!")
                alertDialogBuilder.setMessage("Please check the input data")
                alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which ->
                }
                alertDialogBuilder.show()
            } else{
                var loginStudent = Gson().fromJson(loginUser,Student::class.java)
                Toast.makeText(context, "Logging Success: $email",Toast.LENGTH_LONG).show()
                editor?.putString("existUser",loginUser)
                editor?.apply()
                Log.d("PUT", "onViewCreated: "+sharedPref2?.getString("existUser","FAIL"))
                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            }
        }
    }


}
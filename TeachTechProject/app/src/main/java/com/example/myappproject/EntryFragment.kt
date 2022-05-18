package com.example.myappproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class EntryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entry, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signInBtn= view.findViewById<Button>(R.id.signInBtn)
        val signUpBtn = view.findViewById<Button>(R.id.signUpBtn)
        setListeners(signInBtn,signUpBtn)
        if (checkIsLogin())
            findNavController().navigate(R.id.action_entryFragment_to_profileFragment)
    }



    private fun setListeners(loginBtn: Button, signupBtn: Button){
        loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_loginFragment)
        }
        signupBtn.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_signUpFragment)
        }
    }

    private fun checkIsLogin():Boolean{
        val sharedPref = activity?.getSharedPreferences("currentUser",Context.MODE_PRIVATE)
        Log.d("TEST", "checkIsLogin: "+sharedPref?.getString("existUser","Not found"))
        if (sharedPref?.getString("existUser","Not found")=="Not found")
            return false
        return true
    }
}
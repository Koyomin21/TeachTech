package com.example.myappproject

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


class LandingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        //database imitation
//        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
//        with (sharedPref.edit()) {
//            putString("test@gmail.com", "password")
//            apply()
//        }

                val timer = object: CountDownTimer(1300, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                findNavController().navigate(R.id.action_landingFragment_to_entryFragment)
            }
        }
        timer.start()
    }

    private fun changeFragment(fragment: Fragment) =
        (activity as MainActivity).changeFragment(fragment)


}
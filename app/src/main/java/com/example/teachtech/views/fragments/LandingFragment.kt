package views.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teachtech.R


class LandingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_landing, container, false)
        // findNavController().navigate(R.id.action_homeFragment_to_dataFragment2)

        val timer = object: CountDownTimer(1300, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                findNavController().navigate(R.id.action_landingFragment_to_entryFragment)
            }
        }
        timer.start()

        return view;
    }
}
package views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.teachtech.R


class EntryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_entry, container, false)

        val signInButton = view.findViewById<Button>(R.id.signInBtn)
        val signUpButton = view.findViewById<Button>(R.id.signUpBtn)

        signInButton.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_loginFragment)
        }

        signUpButton.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_signUpFragment)
        }

        return view
    }

}
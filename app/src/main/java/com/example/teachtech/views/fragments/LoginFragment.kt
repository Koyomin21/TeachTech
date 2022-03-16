package views.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.teachtech.R
import interfaces.viewInterfaces.ILoginView
import mu.KotlinLogging

class LoginFragment : Fragment(), ILoginView {

    private val logger = KotlinLogging.logger {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)




        return view;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<Button>(R.id.loginBtn)
        var email:String?


        logger.info{"onViewCreated: Hello! " + loginButton.text.toString()}


        loginButton.setOnClickListener{ view->
            val email: TextView = view.findViewById<EditText>(R.id.email) as TextView
            logger.info{"Login Clicked: " + email.text.toString()}
            val test = view.findViewById<EditText>(R.id.test)
            test.setText("LA LA LA LA RA DA")
        }
    }



    override fun clearFields() {
        TODO("Not yet implemented")
    }

}
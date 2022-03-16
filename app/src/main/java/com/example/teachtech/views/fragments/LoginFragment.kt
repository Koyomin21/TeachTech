package views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.teachtech.R
import com.example.teachtech.presenters.LoginPresenter
import interfaces.presenterInterfaces.ILoginPresenter
import interfaces.viewInterfaces.ILoginView
import mu.KotlinLogging

class LoginFragment : Fragment(), ILoginView {

    private lateinit var presenter: ILoginPresenter;
    private val logger = KotlinLogging.logger {}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(this)

        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        logger.info { "Received Button: " + loginBtn.text.toString() }


        loginBtn.setOnClickListener{
            val email = view.findViewById<EditText>(R.id.email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()

            presenter.login(email, password)
        }

    }



    override fun clearFields() {
        TODO("Not yet implemented")
    }

}
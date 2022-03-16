package views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.teachtech.R
import com.example.teachtech.interfaces.presenterInterfaces.ISignupPresenter
import com.example.teachtech.interfaces.viewInterfaces.ISignupView
import com.example.teachtech.presenters.SignupPresenter

class SignUpFragment : Fragment(), ISignupView {
    private lateinit var presenter: SignupPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.password)
        val firstName = view.findViewById<EditText>(R.id.first_name)
        val lastName = view.findViewById<EditText>(R.id.last_name)
        val signupBtn = view.findViewById<Button>(R.id.signupBtn)

        val emailText = email.text.toString()
        val passwordText = password.text.toString()
        val firstNameText = firstName.text.toString()
        val lastNameText = lastName.text.toString()

        presenter = SignupPresenter(this)
        signupBtn.setOnClickListener{
            if (presenter.isValid(emailText, passwordText, firstNameText, lastNameText)) {
                val res = presenter.signup(emailText, passwordText, firstNameText, lastNameText)
            }
            else {
                Toast.makeText(this.context, "Unsuccessful sign up", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
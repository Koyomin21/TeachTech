package com.example.teachtech.presenters

import com.example.teachtech.database.entity.Student
import com.example.teachtech.database.repository.StudentRepository
import com.example.teachtech.interfaces.presenterInterfaces.ISignupPresenter
import com.example.teachtech.interfaces.viewInterfaces.ISignupView
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class SignupPresenter(private val view: ISignupView): ISignupPresenter, CoroutineScope{
    lateinit var studentRepository: StudentRepository

    override fun signup(email: String, password: String, firstName: String, lastName: String): Long {
        val student = Student(email, password, firstName, lastName)
        var x = studentRepository.insertStudent(student)
        return x
    }

    override fun isValid(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): Boolean {
        var validation = 0
        if (email.contains('@') && email.contains("mail") && email.length >= 7) validation+=1
        if (password.length >= 8) validation+=1
        if (firstName.contains(Regex("[A-Za-z]"))) validation+=1
        if (lastName.contains(Regex("[A-Za-z]"))) validation+=1

        if (validation == 4) return true
        return false;
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")
}
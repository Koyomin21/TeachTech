package com.example.teachtech.interfaces.presenterInterfaces

import com.example.teachtech.database.entity.Student

interface ISignupPresenter {
    fun signup(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ) : Long

    fun isValid(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ) : Boolean
}
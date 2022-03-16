package com.example.teachtech.presenters;

import interfaces.presenterInterfaces.ILoginPresenter
import interfaces.viewInterfaces.ILoginView
import mu.KotlinLogging

class LoginPresenter(private val view: ILoginView) :
    ILoginPresenter {

    private val logger = KotlinLogging.logger {}

    override fun login(email: String, password: String): Int {
        logger.info { "Got Email and password:  $email, $password" }

        return 1
    }

    fun validateInput(email: String, password: String) {

    }

}
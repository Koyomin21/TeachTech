package presenters

import interfaces.presenterInterfaces.ILoginPresenter
import interfaces.viewInterfaces.ILoginView

class LoginPresenter(private val view: ILoginView) :
    ILoginPresenter {
    override fun login(email: String, password: String): Int {
        TODO("Not yet implemented")
    }

}
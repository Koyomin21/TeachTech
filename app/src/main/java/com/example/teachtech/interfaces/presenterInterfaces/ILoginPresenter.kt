package interfaces.presenterInterfaces

interface ILoginPresenter {
    fun login(
        email: String,
        password: String
    ): Int

}
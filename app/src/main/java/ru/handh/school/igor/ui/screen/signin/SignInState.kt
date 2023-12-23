package ru.handh.school.igor.ui.screen.signin

import ru.handh.school.igor.domain.usecase.result.ResultSignIn

val InitialSignInState = SignInState(
    email = "",
    code = "",
    result = ResultSignIn.Default(),
    signInLoading = false,
)

data class SignInState(
    var email: String,
    var code: String,
    val result: ResultSignIn<Unit>,
    val signInLoading: Boolean
)

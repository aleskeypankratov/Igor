package ru.handh.school.igor.ui.screen.signin

import ru.handh.school.igor.domain.usecase.Result

val InitialSignInState = SignInState(
    email = "",
    code = "",
    result = Result.Default(),
    signInLoading = false,
)

data class SignInState(
    var email: String,
    var code: String,
    val result: Result<Unit>,
    val signInLoading: Boolean
)

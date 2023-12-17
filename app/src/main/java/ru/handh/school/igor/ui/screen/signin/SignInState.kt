package ru.handh.school.igor.ui.screen.signin

import ru.handh.school.igor.domain.usecase.Result

val InitialSignInState = SignInState(
    email = "",
    code = "",
    result = Result.UnknownError(),
    signInLoading = false,
)

data class SignInState(
    val email: String,
    val code: String,
    val result: Result<Unit>,
    val signInLoading: Boolean
)

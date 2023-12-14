package ru.handh.school.igor.ui.screen.signin

val InitialSignInState = SignInState(
    email = "",
    code = "",
    signInLoading = false,
)

data class SignInState(
    val email: String,
    val code: String,
    val signInLoading: Boolean
)

package ru.handh.school.igor.ui.screen.signin

val InitialSignInState = SignInState(
    email = "",
    signInLoading = false,
)

data class SignInState(
    var email: String,
    val signInLoading: Boolean
)

package ru.handh.school.igor.ui.screen.signin

val InitialSignInState = SignInState(
    email = "",
    pin = "",
    signInLoading = false,
)

data class SignInState(
    val email: String,
    val pin: String,
    val signInLoading: Boolean
)

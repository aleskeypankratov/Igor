package ru.handh.school.igor.ui.screen.signin

val InitialSignInState = SignInState(
    signInLoading = false
)

data class SignInState(
    val signInLoading: Boolean
)

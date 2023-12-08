package ru.handh.school.igor.ui.screen.signin

val InitialSignInState = SignInState(
    mail = "",
    signInLoading = false,

)

data class SignInState(
    val mail: String,
    val signInLoading: Boolean
)

package ru.handh.school.igor.domain.usecase.result

sealed interface ResultSignIn {
    data object LoggedIn : ResultSignIn
    data object GotSession : ResultSignIn
    data object UnknownError : ResultSignIn
    data object InvalidEmail : ResultSignIn
    data object InvalidCode : ResultSignIn
    data object ServerError : ResultSignIn
    data object Default : ResultSignIn
}
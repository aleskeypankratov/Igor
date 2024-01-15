package ru.handh.school.igor.domain.usecase.result
//sealed class ResultSignIn<T>(val data: T? = null) {
//    class LoggedIn<T>: ResultSignIn<T>()
//    class GotSession<T>: ResultSignIn<T>()
//    class UnknownError<T>: ResultSignIn<T>()
//    class InvalidEmail<T>: ResultSignIn<T>()
//    class InvalidCode<T>: ResultSignIn<T>()
//    class ServerError<T>: ResultSignIn<T>()
//    class Default<T>: ResultSignIn<T>()
//}

sealed interface ResultSignIn {
    data object LoggedIn : ResultSignIn
    data object GotSession : ResultSignIn
    data object UnknownError : ResultSignIn
    data object InvalidEmail : ResultSignIn
    data object InvalidCode : ResultSignIn
    data object ServerError : ResultSignIn
    data object Default : ResultSignIn
}
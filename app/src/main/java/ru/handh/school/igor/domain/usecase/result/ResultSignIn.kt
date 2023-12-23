package ru.handh.school.igor.domain.usecase.result
sealed class ResultSignIn<T>(val data: T? = null) {
    class LoggedIn<T>(data: T? = null): ResultSignIn<T>(data)
    class GotSession<T>(data: T? = null): ResultSignIn<T>(data)
    class UnknownError<T>: ResultSignIn<T>()
    class RequestError<T>: ResultSignIn<T>()
    class ServerError<T>: ResultSignIn<T>()
    class Default<T>: ResultSignIn<T>()
}

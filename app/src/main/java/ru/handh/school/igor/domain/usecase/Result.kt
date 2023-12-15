package ru.handh.school.igor.domain.usecase
sealed class Result<T>(val data: T? = null) {
    class LoggedIn<T>(data: T? = null): Result<T>(data)
    class GotSession<T>(data: T? = null): Result<T>(data)
    class UnknownError<T>: Result<T>()
}

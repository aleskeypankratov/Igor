package ru.handh.school.igor.domain.usecase.result

sealed class ResultProject<T>(val data: T? = null) {
    class GotProject<T> : ResultProject<T>()
    class UnknownError<T> : ResultProject<T>()
    class RequestError<T> : ResultProject<T>()
    class ServerError<T> : ResultProject<T>()
    class Default<T> : ResultProject<T>()

}
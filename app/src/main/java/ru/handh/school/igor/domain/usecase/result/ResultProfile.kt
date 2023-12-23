package ru.handh.school.igor.domain.usecase.result

sealed class ResultProfile<T>(val data: T? = null) {

    class UnknownError<T> : ResultProfile<T>()
    class LogOut<T> : ResultProfile<T>()
    class RequestError<T> : ResultProfile<T>()
    class ServerError<T> : ResultProfile<T>()
    class Default<T> : ResultProfile<T>()
}


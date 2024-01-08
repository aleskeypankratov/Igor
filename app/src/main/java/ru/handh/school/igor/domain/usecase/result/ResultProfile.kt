package ru.handh.school.igor.domain.usecase.result

sealed class ResultProfile<T>(val data: T? = null) {

    class LogOut<T> : ResultProfile<T>()
    class GotProfile<T> : ResultProfile<T>()
    class UnknownError<T> : ResultProfile<T>()
    class ServerError<T> : ResultProfile<T>()
    class Default<T> : ResultProfile<T>()
}


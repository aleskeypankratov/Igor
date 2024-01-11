package ru.handh.school.igor.domain.usecase.result

sealed class ResultProject<T>(val data: T? = null) {
    class GotProject<T>(data: T) : ResultProject<T>(data)
    class GotProjectDetail<T>(data: T) : ResultProject<T>(data)
    class UnknownError<T> : ResultProject<T>()
    class Loading<T> : ResultProject<T>()
    class ServerError<T> : ResultProject<T>()
    class Default<T> : ResultProject<T>()

}
package ru.handh.school.igor.domain.usecase.result

sealed class ResultProject<T>(val data: T? = null) {
    class GotProject<T>(projects: List<String>?) : ResultProject<T>()
    class UnknownError<T> : ResultProject<T>()
    class Loading<T> : ResultProject<T>()
    class ServerError<T>(error: String?) : ResultProject<T>()
    class Default<T> : ResultProject<T>()

}
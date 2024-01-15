package ru.handh.school.igor.domain.usecase.result

import ru.handh.school.igor.domain.model.db.ProfileInfo

/*
sealed class ResultProfile<T>(val data: T? = null) {

    class LogOut<T> : ResultProfile<T>()
    class GotProfile<T>(data: T) : ResultProfile<T>(data)
    class UnknownError<T> : ResultProfile<T>()
    class ServerError<T> : ResultProfile<T>()
    class Default<T> : ResultProfile<T>()
}
*/

sealed interface ResultProfile {
    data object LogOut : ResultProfile
    data class GotProfile(val profile: ProfileInfo) : ResultProfile
    data object UnknownError : ResultProfile
    data object ServerError : ResultProfile
    data object Default : ResultProfile

}


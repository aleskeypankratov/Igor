package ru.handh.school.igor.domain.usecase.result

import ru.handh.school.igor.domain.model.db.ProfileInfo

sealed interface ResultProfile {
    data object LogOut : ResultProfile
    data class GotProfile(val profile: ProfileInfo) : ResultProfile
    data object UnknownError : ResultProfile
    data object ServerError : ResultProfile
    data object Default : ResultProfile

}


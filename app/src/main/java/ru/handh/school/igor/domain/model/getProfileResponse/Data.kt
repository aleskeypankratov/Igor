package ru.handh.school.igor.domain.model.getProfileResponse

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val profile: Profile?
)
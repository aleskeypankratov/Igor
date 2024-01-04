package ru.handh.school.igor.domain.model.getProfileResponse

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val name: String? = null,
    val surname: String? = null
)
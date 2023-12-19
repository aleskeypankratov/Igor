package ru.handh.school.igor.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetSessionResponse (
    @SerialName("refreshToken") val refreshToken: String
)
package ru.handh.school.igor.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class PostRefreshRequest(
    @SerialName("refreshToken") var refreshToken: String?
)
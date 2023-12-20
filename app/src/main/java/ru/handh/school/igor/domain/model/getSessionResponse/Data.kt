package ru.handh.school.igor.domain.model.getSessionResponse

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val session: Session
)
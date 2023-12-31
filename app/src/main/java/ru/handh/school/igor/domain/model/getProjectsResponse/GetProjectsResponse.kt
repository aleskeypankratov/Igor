package ru.handh.school.igor.domain.model.getProjectsResponse

import kotlinx.serialization.Serializable

@Serializable
data class GetProjectsResponse(
    val `data`: Data?
)
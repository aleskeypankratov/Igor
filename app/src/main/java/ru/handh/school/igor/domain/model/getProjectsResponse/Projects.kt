package ru.handh.school.igor.domain.model.getProjectsResponse

import kotlinx.serialization.Serializable

@Serializable
data class Projects(
    val name: String?,
    val description: String?,
    val id: String?
)
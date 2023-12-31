package ru.handh.school.igor.domain.model.getProjectsResponse

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val hasMore: Boolean?,
    val projects: List<String>?
)
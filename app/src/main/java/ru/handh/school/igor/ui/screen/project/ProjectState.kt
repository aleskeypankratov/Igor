package ru.handh.school.igor.ui.screen.project

import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse
import ru.handh.school.igor.domain.usecase.result.ResultProject

val InitialProjectState = ProjectState(
    result = ResultProject.Default(),
    projects = listOf()
)

data class ProjectState(
    var result: ResultProject<GetProjectsResponse>,
    var projects: List<String>
)

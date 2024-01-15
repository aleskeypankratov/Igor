package ru.handh.school.igor.ui.screen.project

import Project
import ru.handh.school.igor.domain.model.getProjectsResponse.Projects
import ru.handh.school.igor.domain.usecase.result.ResultProject

val InitialProjectState = ProjectState(
    result = ResultProject.Default,
    projects = listOf(Projects(name = "", description = "", id = "")),
    detailProject = Project(name = "", description = "", id = "")
)

data class ProjectState(
    var result: ResultProject,
    var projects: List<Projects>,
    var detailProject: Project
)
